package com.SistemaAntiIncendio.Spring.factoryPattern;

import com.SistemaAntiIncendio.Spring.proxyPattern.CommunicationChannel;
import com.SistemaAntiIncendio.Spring.proxyPattern.CommunicationChannelProxy;
import com.SistemaAntiIncendio.Spring.proxyPattern.HttpCommunicationChannel;

public class HttpCommunicationChannelFactory implements CommunicationChannelFactory {

	private String baseUrl;

    public HttpCommunicationChannelFactory(String baseUrl) {
        this.baseUrl = baseUrl;
    }
	
    @Override
    public CommunicationChannel createCommunicationChannel() {
        return new CommunicationChannelProxy(new HttpCommunicationChannel(baseUrl));
    }
}
