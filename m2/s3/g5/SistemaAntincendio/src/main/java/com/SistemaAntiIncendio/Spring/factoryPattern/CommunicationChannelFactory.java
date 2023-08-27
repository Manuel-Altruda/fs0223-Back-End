package com.SistemaAntiIncendio.Spring.factoryPattern;

import com.SistemaAntiIncendio.Spring.proxyPattern.CommunicationChannel;

public interface CommunicationChannelFactory {
	
	 CommunicationChannel createCommunicationChannel();
	 
}
