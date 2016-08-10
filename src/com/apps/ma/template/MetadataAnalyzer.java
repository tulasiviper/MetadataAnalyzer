package com.apps.ma.template;

public class MetadataAnalyzer
{

	public String nChannel;
	public String nMulticastIP;
	public String nSourceIP;
	public String nPorts;
	
	public MetadataAnalyzer(String nChannel, String nMulticastIP, String nSourceIP, String nPorts) {
		super();
		this.nChannel = nChannel;
		this.nMulticastIP = nMulticastIP;
		this.nSourceIP = nSourceIP;
		this.nPorts = nPorts;
	}

	public String getnChannel()
	{
		return nChannel;
	}

	public void setnChannel(String nChannel)
	{
		this.nChannel = nChannel;
	}

	public String getnMulticastIP()
	{
		return nMulticastIP;
	}

	public void setnMulticastIP(String nMulticastIP)
	{
		this.nMulticastIP = nMulticastIP;
	}

	public String getnSourceIP()
	{
		return nSourceIP;
	}

	public void setnSourceIP(String nSourceIP)
	{
		this.nSourceIP = nSourceIP;
	}

	public String getnPorts()
	{
		return nPorts;
	}

	public void setnPorts(String nPorts)
	{
		this.nPorts = nPorts;
	}


}
