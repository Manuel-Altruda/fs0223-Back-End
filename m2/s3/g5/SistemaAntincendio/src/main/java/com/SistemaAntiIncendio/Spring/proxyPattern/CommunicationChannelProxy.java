package com.SistemaAntiIncendio.Spring.proxyPattern;

public class CommunicationChannelProxy implements CommunicationChannel {
	
	private CommunicationChannel realChannel;

    public CommunicationChannelProxy(CommunicationChannel realChannel) {
        this.realChannel = realChannel;
    }

    @Override
    public void sendAlarmData(String data) {
        realChannel.sendAlarmData(data);
    }
    
}
