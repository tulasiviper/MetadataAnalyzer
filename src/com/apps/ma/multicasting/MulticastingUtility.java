package com.apps.ma.multicasting;
import java.awt.Color;

import com.apps.ma.template.MetadataAnalyzer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.UnsupportedAddressTypeException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MulticastingUtility {

    ByteBuffer buffer;

    InetAddress nAddress;
    String getMulticastData;
    String pChannelId;
    String pMulticastIP;
    String pSourceIP;
    String pPorts;
    NetworkInterface nInterf;
    DatagramChannel multicastChannel;
    public static final int NTHREADS = 10;
    public static final String nInterface = "eth5";

    public HashMap<String, byte[]> receiveTsPacketsOfChannels;
//public HashMap<String, List<byte[]>> allChannelTsPacketsRecords = new HashMap<String, List<byte[]>>();
    public HashMap<String, byte[]> allChannelTsPacketsRecords = new HashMap<>();

    private static final FileAttribute<?> FileAttribute = null;
    ExecutorService threadPoolList = (ExecutorService) Executors.newFixedThreadPool(NTHREADS);

    /*public CompletableFuture<HashMap<String, List<byte[]>>> doRenderMulticasting(ScheduledExecutorService service,long pTime,String channelId,String nInterface,String nMulticastIP, String nSourceIP, String nPort){
		
	CompletableFuture<HashMap<String,List<byte[]>>> futureCount = CompletableFuture.supplyAsync(
            () -> 
                	doMulticasting(service,pTime,channelId,nInterface,nMulticastIP,nSourceIP,nPort)
                    
            ,threadPoolList);
	
			
	return futureCount;
}*/
    public void doRenderMulticastingForAll(int processingTime, List<MetadataAnalyzer> allChannelsDetails) {

        long scheduledProcessingTime = System.currentTimeMillis() + processingTime * 60000;

        //Converting minutes to milliseconds.
        ScheduledExecutorService scheduleMulticastingPool = Executors.newScheduledThreadPool(NTHREADS);
        ScheduledFuture scheduledMulticast;
        Runnable runMulticasting;
        runMulticasting = () -> {
            System.out.println("Multicasting renderer thread starting.!!!" + Thread.currentThread());
            for (int iCount = 0; iCount <= allChannelsDetails.size() - 1; iCount++) {
                pChannelId = allChannelsDetails.get(iCount).getnChannel();
                pMulticastIP = allChannelsDetails.get(iCount).getnMulticastIP();
                pSourceIP = allChannelsDetails.get(iCount).getnSourceIP();
                pPorts = allChannelsDetails.get(iCount).getnPorts();
                String[] port = pPorts.split(",");
                System.out.println("Before invoking multicasting for this channel: " + allChannelsDetails.get(iCount).getnChannel());
                System.out.println(nInterface + " " + pMulticastIP + " " + pSourceIP + " " + port[0]);
                CompletableFuture<Void> futureCount;
                /*try {
                receiveTsPacketsOfChannels = futureCount.get();
                writeTsFileForChannel(receiveTsPacketsOfChannels);
                } catch (InterruptedException e) {
                e.printStackTrace();
                } catch (ExecutionException e) {
                e.printStackTrace();
                }*/
                futureCount = CompletableFuture.supplyAsync(
                        ()
                                -> doMulticasting(scheduleMulticastingPool, scheduledProcessingTime, pChannelId, nInterface, pMulticastIP, pSourceIP, port[0]), threadPoolList)
                					.thenAcceptAsync((java.util.HashMap<java.lang.String, byte[]> receiveTsPacketsOfChannels1) -> writeTsFileForChannel(receiveTsPacketsOfChannels1));
            }
        };

        scheduledMulticast = scheduleMulticastingPool.scheduleWithFixedDelay(runMulticasting, 1, 1, TimeUnit.SECONDS);

        //ScheduledFuture scheduleMulticast = scheduleMulticastingPool.schedule(callableMulticastingTask, 5, TimeUnit.SECONDS);
    }

    protected boolean writeTsFileForChannel(HashMap<String, byte[]> channelRecordsinMap2) {
        String channelName;
        String[] splitChannelName;
        Vector<String> channelList = new Vector<>();

        List<byte[]> Universal = new ArrayList<>();
        List<byte[]> FoxNewsSD = new ArrayList<>();
        List<byte[]> Golf_SD = new ArrayList<>();
        List<byte[]> USA_SD = new ArrayList<>();
        List<byte[]> HLN_HD = new ArrayList<>();
        List<byte[]> Venezuela_SD = new ArrayList<>();
        List<byte[]> ESPN_SD = new ArrayList<>();
        List<byte[]> Hallmark_SD = new ArrayList<>();
        List<byte[]> Teen_Nick_SD = new ArrayList<>();
        List<byte[]> MTV_Jams_SD = new ArrayList<>();
        List<byte[]> Mun2_SD = new ArrayList<>();
        List<byte[]> HSN_SD = new ArrayList<>();
        List<byte[]> CBSESPORTS_SD = new ArrayList<>();
        List<byte[]> Spike_SD = new ArrayList<>();
        List<byte[]> CSPAN_SD = new ArrayList<>();
        List<byte[]> Esquire_SD = new ArrayList<>();
        List<byte[]> Discovery_SD = new ArrayList<>();
        List<byte[]> BigBunny1 = new ArrayList<>();
        List<byte[]> BigBunny2 = new ArrayList<>();

        if (!((Map<String, byte[]>) channelRecordsinMap2).isEmpty()) {
            for (String key : ((Map<String, byte[]>) channelRecordsinMap2).keySet()) {
                System.out.println("Database key: " + key);
                splitChannelName = key.split("-");
                channelName = splitChannelName[0];
                if (!channelList.contains(channelName)) {
                    channelList.add(channelName);
                } else {
                    System.out.println("ChannelName already exist!");
                }

                if (channelName.equalsIgnoreCase("Universal_HD")) {
                    Universal.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("Fox_News_SD")) {
                    FoxNewsSD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("Golf_SD")) {
                    Golf_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("USA_SD")) {
                    USA_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("HLN_HD")) {
                    HLN_HD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("Venezuela_SD")) {
                    Venezuela_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("ESPN_SD")) {
                    ESPN_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("Hallmark_SD")) {
                    Hallmark_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("Teen_Nick_SD")) {
                    Teen_Nick_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("MTV_Jams_SD")) {
                    MTV_Jams_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("Mun2_SD")) {
                    Mun2_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("HSN_SD")) {
                    HSN_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("CBSESPORTS_SD")) {
                    CBSESPORTS_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("Spike_SD")) {
                    Spike_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("CSPAN_SD")) {
                    CSPAN_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("Esquire_SD")) {
                    Esquire_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("Discovery_SD")) {
                    Discovery_SD.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("BigBunny1")) {
                    BigBunny1.add(channelRecordsinMap2.get(key));
                } else if (channelName.equalsIgnoreCase("BigBunny2")) {
                    BigBunny2.add(channelRecordsinMap2.get(key));
                }

            }//end of for loop

            System.out.println("Channels Count: " + channelList.size());

            for (int i = 0; i <= channelList.size() - 1; i++) {

                if (channelList.get(i).equals("Universal") && Universal.size() > 0) {
                    String channelId = "Universal";
                    doWriteTsFileOnDisk(channelId, Universal);
                } else if (FoxNewsSD.size() > 0) {
                    String channelId = "FoxNewsSD";
                    doWriteTsFileOnDisk(channelId, FoxNewsSD);
                } else if (channelList.get(i).equals("Golf_SD") && Golf_SD.size() > 0) {
                    String channelId = "Golf_SD";
                    doWriteTsFileOnDisk(channelId, Golf_SD);
                } else if (channelList.get(i).equals("USA_SD") && USA_SD.size() > 0) {
                    String channelId = "USA_SD";
                    doWriteTsFileOnDisk(channelId, USA_SD);
                } else if (channelList.get(i).equals("HLN_HD") && HLN_HD.size() > 0) {
                    String channelId = "HLN_HD";
                    doWriteTsFileOnDisk(channelId, HLN_HD);
                } else if (channelList.get(i).equals("Venezuela_SD") && Venezuela_SD.size() > 0) {
                    String channelId = "Venezuela_SD";
                    doWriteTsFileOnDisk(channelId, Venezuela_SD);
                } else if (channelList.get(i).equals("ESPN_SD") && ESPN_SD.size() > 0) {
                    String channelId = "ESPN_SD";
                    doWriteTsFileOnDisk(channelId, ESPN_SD);
                } else if (channelList.get(i).equals("Hallmark_SD") && Hallmark_SD.size() > 0) {
                    String channelId = "Hallmark_SD";
                    doWriteTsFileOnDisk(channelId, Hallmark_SD);
                } else if (channelList.get(i).equals("Teen_Nick_SD") && Teen_Nick_SD.size() > 0) {
                    String channelId = "Teen_Nick_SD";
                    doWriteTsFileOnDisk(channelId, Teen_Nick_SD);
                } else if (channelList.get(i).equals("MTV_Jams_SD") && MTV_Jams_SD.size() > 0) {
                    String channelId = "MTV_Jams_SD";
                    doWriteTsFileOnDisk(channelId, MTV_Jams_SD);
                } else if (channelList.get(i).equals("Mun2_SD") && Mun2_SD.size() > 0) {
                    String channelId = "Mun2_SD";
                    doWriteTsFileOnDisk(channelId, Mun2_SD);
                } else if (channelList.get(i).equals("HSN_SD") && HSN_SD.size() > 0) {
                    String channelId = "HSN_SD";
                    doWriteTsFileOnDisk(channelId, HSN_SD);
                } else if (channelList.get(i).equals("CBSESPORTS_SD") && CBSESPORTS_SD.size() > 0) {
                    String channelId = "CBSESPORTS_SD";
                    doWriteTsFileOnDisk(channelId, CBSESPORTS_SD);
                } else if (channelList.get(i).equals("Spike_SD") && Spike_SD.size() > 0) {
                    String channelId = "Spike_SD";
                    doWriteTsFileOnDisk(channelId, Spike_SD);
                } else if (channelList.get(i).equals("CSPAN_SD") && CSPAN_SD.size() > 0) {
                    String channelId = "CSPAN_SD";
                    doWriteTsFileOnDisk(channelId, CSPAN_SD);
                } else if (channelList.get(i).equals("Esquire_SD") && Esquire_SD.size() > 0) {
                    String channelId = "Esquire_SD";
                    doWriteTsFileOnDisk(channelId, Esquire_SD);
                } else if (channelList.get(i).equals("Discovery_SD") && Discovery_SD.size() > 0) {
                    String channelId = "Discovery_SD";
                    doWriteTsFileOnDisk(channelId, Discovery_SD);
                } else if (channelList.get(i).equals("BigBunny1") && BigBunny1.size() > 0) {
                    String channelId = "BigBunny1";
                    System.out.println("Before writing to disk. Got BigBunny1 list!!!");
                    doWriteTsFileOnDisk(channelId, BigBunny1);
                } else if (channelList.get(i).equals("BigBunny2") && BigBunny2.size() > 0) {
                    String channelId = "BigBunny2";
                    System.out.println("Before writing to disk. Got BigBunny2 list!!!");
                    doWriteTsFileOnDisk(channelId, BigBunny2);
                } else {
                    System.out.println("No such channel exists!!");
                    Logger.getLogger("No such channel exists!!");
                }
            }// end of for loop	
        } else {
            System.out.println("Empty key returned from channels record database.");
        }

        return true;
    }

    protected HashMap<String, byte[]> doMulticasting(ScheduledExecutorService serve, long processingTime, String channelId, String nInterface, String nMulticastIP, String nSourceIP, String nPort) {
        int mport = 1234;
        int fileSeq = 00000;
        int counter = 0;
        ByteBuffer compressedFile = null;
        List<String> tsPackets = new ArrayList<>();
        List<byte[]> tsPacketsBytes = new ArrayList<>();

        System.out.println("Am in doMulticasting method");
        
        /*try
		{
		Enumeration<NetworkInterface> nie = NetworkInterface.getNetworkInterfaces ();
		       while (nie.hasMoreElements()) {
		           NetworkInterface ni = nie.nextElement();
		           System.out.println(ni);
		       }
		}catch(IOException ex){
		System.out.println(ex.getMessage());
		}*/
        try {
            nInterf = NetworkInterface.getByName("eth5");           
        } catch (SocketException ex) {
            Logger.getLogger("eth0 interface not found. SocketException occured." + ex.getMessage());
            System.out.println("eth0 interface not found. SocketException occured." + ex.getMessage());
        }
        try {
            nAddress = InetAddress.getByName(nMulticastIP);            
        } catch (UnknownHostException ex) {
            Logger.getLogger("Unable to reach 239.0.0.2. Exception occured" + ex.getMessage());
            System.out.println("Unable to reach 239.0.0.2. Exception occured" + ex.getMessage());
        }

        try {
            /*
	*StandardProtocolFamily provides list of constants for networking
	*StandardSocketOptions class provides the list of socket options used by network channels in channels package
	*
	*StandardSocketOptions.SO_REUSEADDR: For datagram-oriented sockets the socket option is used to allow multiple programs bind to the same address. This option should be enabled when the socket is to be used for Internet Protocol (IP) multicasting.
	An implementation allows this socket option to be set before the socket is bound or connected.
	*StandardSocketOptions.IP_MULTICAST_IF: The value of this socket option is a NetworkInterface that represents the outgoing interface for multicast datagrams sent by the datagram-oriented socket.
             */
        	
        	
        	try
        	{
        		
        		multicastChannel = DatagramChannel.open(StandardProtocolFamily.INET)
                        .setOption(StandardSocketOptions.SO_REUSEADDR, true)
                        .bind(new InetSocketAddress(Integer.parseInt(nPort)));
        		System.out.println("Successfully binded to multicast port." +Integer.parseInt(nPort));
               
        	}catch(UnsupportedAddressTypeException UATE){
        		System.out.println("Unsupported Address Exception while doing multicasting!!"+UATE.getMessage());
        	}catch(ClosedChannelException CCE){
        		System.out.println("Closed Channel Exception while doing multicasting!!" +CCE.getMessage());
        	}catch(SecurityException SE){
        		System.out.println("Security Exception while doing multicasting!!" +SE.getMessage());
        	}catch(IOException IO){
        		System.out.println("IOException while doing multicasting!!" +IO.getMessage());
        	}catch(Exception ex){
        		System.out.println("Generic Exception while doing multicasting." +ex.getMessage());
        	}
        	multicastChannel.configureBlocking(true);
        	try
        	{
        		multicastChannel.join(InetAddress.getByName(nMulticastIP), nInterf, InetAddress.getByName(nSourceIP));
                System.out.println("Successfully joined multicast group." +nMulticastIP+":"+nSourceIP+":"+nInterf);
        	}catch(IllegalArgumentException IAE){
        		System.out.println("Illegal Argument Exception. Unable to bind to multicast group."+IAE.getMessage());
        	}
        	catch(IllegalStateException ISE){
        		System.out.println("IllegalStateException. Unable to bind to multicast group."+ISE.getMessage());
        	}
        	catch(UnsupportedOperationException uoe){
        		System.out.println("UnsupportedOperationException. Unable to bind to multicast group."+uoe.getMessage());
        	}
        	catch(ClosedChannelException cce){
        		System.out.println("ClosedChannelException. Unable to bind to multicast group."+cce.getMessage());
        	}        	
        	catch(IOException IO){
        		System.out.println("IOException while doing multicasting!!" +IO.getMessage());
        	}
        	catch(SecurityException SE){
        		System.out.println("Security Exception while doing multicasting!!" +SE.getMessage());
        	}
        	
        	
        	
        	
        	 
             //multicastChannel.join(nAddress, nInterf);
             
            //define the buffer, receive and store the datagram packets in buffer. receive method throws IOException
            while (processingTime > System.currentTimeMillis()) {

                try {
                    buffer = ByteBuffer.allocate((Integer)multicastChannel.getOption(StandardSocketOptions.SO_RCVBUF).intValue());                    
                    multicastChannel.receive(buffer);
                    System.out.println("Am receiving the buffer." +buffer.get());
                } catch (IOException ex) {
                    System.out.println("Data receive error from multicast channel." + ex.getMessage());
                }

                buffer.flip(); //flipping the buffer to write mode.
                fileSeq++;
                byte[] bytes = new byte[buffer.limit()];

                buffer.get(bytes,0,buffer.limit());

                System.out.println("===========================================");
                System.out.println(channelId + " - " + "UDP MulticastPackets: " + " " + Thread.currentThread());
                System.out.println(new String(bytes));

                tsPacketsBytes.add(bytes);
                //allChannelTsPacketsRecords.put(channelId+"-"+Integer.toString(fileSeq), tsPacketsBytes);
                allChannelTsPacketsRecords.put(channelId + "-" + Integer.toString(fileSeq), bytes);
                System.out.println("TsPackets2Bytes: " + tsPacketsBytes.size());
                System.out.println("Channels database size: " + allChannelTsPacketsRecords.size());
                System.out.println("===========================================");

                buffer.clear();

                counter++;
                if (counter == 20) {
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter = 0;

                }

            } // end of while loop

            //Sleep for 3 secs after processing 10 packets
            //end of run() method
//end of creating thread
            if (processingTime < System.currentTimeMillis()) {
                System.out.println("TimeUp!!!");
                try {
                    Thread.sleep(5000);
                    //System.exit(1);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }

        }catch(Exception ex){
        	System.out.println("Exception:::::::::::" +ex.getMessage());
        } finally {
            if (multicastChannel == null) {
                try {
                    multicastChannel.close();
                    System.exit(0);
                } catch (IOException e) {
                    Logger.getLogger("Error while closing multicast channel." + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return allChannelTsPacketsRecords;
    }

    public void doWriteTsFileOnDisk(String channelId, List<byte[]> tsPacketsForChannel) {
        Path tsPacketsStorageFiles;
        Path tsPacketsStorageDir;
        ByteBuffer tempBufferStorage;
        AsynchronousFileChannel asyncTsFileChannel;

        tempBufferStorage = ByteBuffer.allocate(188 * tsPacketsForChannel.size());
        byte[] storeTempTsPackets = createSingleTsFile(tsPacketsForChannel);
        tempBufferStorage.put(storeTempTsPackets);

        tsPacketsStorageDir = Paths.get("C:\\" + "ChannelsList" + File.separator + channelId);
        tsPacketsStorageFiles = Paths.get(tsPacketsStorageDir + File.separator + channelId + "-" + "0000001" + ".ts");
        try {
            if (!Files.exists(tsPacketsStorageFiles)) {
                Files.createDirectories(tsPacketsStorageDir);
                Files.createFile(tsPacketsStorageFiles);
            }
            System.out.println("Writing" + " " + tsPacketsStorageFiles + " " + "to the disk.");
            asyncTsFileChannel = AsynchronousFileChannel.open(tsPacketsStorageFiles, StandardOpenOption.WRITE);
            asyncTsFileChannel.write(tempBufferStorage, 0);
        } catch (IOException e) {
            Logger.getLogger("Error in writing the Universal TS file asynchronously" + e.getMessage());
            System.out.println("Error in writing the Universal TS file asynchronously" + e.getMessage());
            e.printStackTrace();
        }

    }

    public byte[] createSingleTsFile(List<byte[]> tsPacketsCollection) {
        int capacityOfArray = 0;
        byte[] resultByteArray;

        System.out.println("Inside createSingleTsFile: " + tsPacketsCollection.size());
        capacityOfArray = tsPacketsCollection.size() * 188;
        System.out.println("CapacityOfArray: " + capacityOfArray);
        final ByteArrayOutputStream bytes = new ByteArrayOutputStream();

        for (int pCount = 0; pCount <= tsPacketsCollection.size() - 5; pCount++) {
            byte[] singleTsPacket = tsPacketsCollection.get(pCount);
            try {
                bytes.write(singleTsPacket);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        return bytes.toByteArray();
    }

    public static void main(String args[]) {
        //MulticastingUtility multicast = new MulticastingUtility();
        //multicast.doRenderMulticasting("eth3", "239.0.0.1", "239.0.0.1", "1234");
        
    }
    
    private String getNetworkInterface() {
        final String IPADDRESS_PATTERN = "(10|172)\\." + "(16[8-9]|2(\\d\\d?)|3(\\d\\d?)|4(\\d\\d?))\\."
                + "([01]?\\d\\d?\\d?)\\." + "([01]?\\d\\d?\\d?)$";
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(IPADDRESS_PATTERN);
        try {
            Enumeration<InetAddress> inetAddresses;
            Enumeration<NetworkInterface> nwInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            for (NetworkInterface netint : Collections.list(nwInterfaces)) {
                inetAddresses = netint.getInetAddresses();
                if (inetAddresses != null) {
                    for (InetAddress inetAddress : Collections
                            .list(inetAddresses)) {
                        if (netint.isUp()) {
                            matcher = pattern.matcher(inetAddress
                                    .getHostAddress());
                            if (matcher.matches()) {
                                return netint.getName();
                            }
                        }
                    }
                }
            }
        } catch (SocketException se) {
            System.out.println(se.getMessage());
        }
        return "unknown";
    }
    
    public void joinMulticast() {
        String nwInfo = getNetworkInterface();
        List<byte[]> tsPacketsBytes = new ArrayList<>();
        if (!nwInfo.equals("unknown")) {
            NetworkInterface nwInterface = null;
            try {
                nwInterface = NetworkInterface.getByName(nwInfo);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            try {
                // Initialize a Datagram channel to recieve datagrams
                DatagramChannel channel = DatagramChannel.open(StandardProtocolFamily.INET)
                        .setOption(StandardSocketOptions.SO_REUSEADDR, true);
                // Bind Datagram channel to a port (port from the transcoder)
                channel.bind(new InetSocketAddress(36202));
                channel.configureBlocking(true);
                // join network to receive the channel data
                channel.join(InetAddress.getByName("232.36.124.202"), nwInterface, InetAddress.getByName("10.22.122.113"));
                ByteBuffer buffer = ByteBuffer.allocate((channel.getOption(StandardSocketOptions.SO_RCVBUF)));
                byte[] tsPacket = new byte['¼'];
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");    
                Date date = new Date(System.currentTimeMillis());
                System.out.println("Start Time : " + dateFormat.format(date));
                long executionTime = 2 * 60000 + System.currentTimeMillis();
                while (true) {
                    buffer.clear();
                    channel.receive(buffer);
                    buffer.flip();
                    byte[] ipPacket = new byte[buffer.remaining()];
                    buffer.get(ipPacket, 0, ipPacket.length);
                    for (int i = 0; i < ipPacket.length; i += 188) {
                        System.arraycopy(ipPacket, i, tsPacket, 0, 188);
                        tsPacketsBytes.add(tsPacket);
                    }
                    System.out.println("TsPackets2Bytes: " + tsPacketsBytes.size());
                    if (executionTime < System.currentTimeMillis()) {
                        break;
                    }
                }
                date = new Date(System.currentTimeMillis());
                System.out.println("Finish Time : " + dateFormat.format(date));
                doWriteTsFileOnDisk("Universal-HD", tsPacketsBytes);
                buffer.clear();
                channel.close();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }
}
