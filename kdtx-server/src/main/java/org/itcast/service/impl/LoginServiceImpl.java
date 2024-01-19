package org.itcast.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.captcha.generator.MathGenerator;
import org.itcast.dto.LoginDTO;
import org.itcast.entity.Code;
import org.itcast.entity.User;
import org.itcast.exception.BaseException;
import org.itcast.exception.ParamIllegalException;
import org.itcast.mapper.UserMapper;
import org.itcast.result.Result;
import org.itcast.service.LoginService;
import org.itcast.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    StringRedisTemplate redisTemplate;
    @Override
    public Result login(LoginDTO dto) {
        if(dto == null){
            //参数异常
            throw new ParamIllegalException("登录参数为空");
        }

        String s = redisTemplate.opsForValue().get("code_"+dto.getUuid());
        boolean verify = new MathGenerator().verify(s, dto.getCode());
        if (!verify){
            throw new BaseException("验证码错误");
        }

        dto.setPassword(DigestUtils.md5DigestAsHex(dto.getPassword().getBytes()));
        User user = userMapper.login(dto);

        if(user == null){ //代表用户不存在得
            throw new BaseException("用户名或密码错误");
        }


        //密码相等
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("user_id",user.getUserId());

        return Result.success(JwtUtil.createJWT("itcast",7200000,claims));
    }

    @Override
    public Code getCode() {
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(160,60,4,0);
        captcha.setGenerator(new MathGenerator(1));
        String code = captcha.getCode();
        String uuid = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set("code_"+uuid,code);
        return new Code(captcha.getImageBase64(),uuid);
    }
}
