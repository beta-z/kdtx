package org.itcast.service;


import org.itcast.common.Fenye;
import org.itcast.common.PageResult;
import org.itcast.dto.TransferlistDTO;

public interface TransferServers {

    Fenye getTransferlist(TransferlistDTO params);

    void divertLeads(String type, Long userId, Long transferUserId);
}
