package com.geekcap.springintegrationexample.service;

import com.geekcap.springintegrationexample.model.Message;

public interface PublishService
{
    public void send( Message message );
}
