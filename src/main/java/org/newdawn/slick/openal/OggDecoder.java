package org.newdawn.slick.openal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * Decode an OGG file to PCM data
 * 
 * @author Kevin Glass
 */
public class OggDecoder {
	/** The conversion buffer size */
	private int convsize = 4096 * 4;
	/** The buffer used to read OGG file */
	private byte[] convbuffer = new byte[convsize]; // take 8k out of the data segment, not the stack
	
	/**
	 * Create a new OGG decoder
	 */
	public OggDecoder() {
	}
	
	/**
	 * Get the data out of an OGG file 
	 * 
	 * @param input The input stream from which to read the OGG file
	 * @return The data describing the OGG thats been read
	 * @throws IOException Indicaites a failure to read the OGG file
	 */
	public OggData getData(InputStream input) throws IOException {
		if (input == null) {
			throw new IOException("Failed to read OGG, source does not exist?");
		}
		ByteArrayOutputStream dataout = new ByteArrayOutputStream();

		OggInputStream oggInput = new OggInputStream(input);
		
		boolean done = false;
		while (!oggInput.atEnd()) {
			dataout.write(oggInput.read());
		}
	
		OggData ogg = new OggData();
		ogg.channels = oggInput.getChannels();
		ogg.rate = oggInput.getRate();
		
		byte[] data = dataout.toByteArray();
		ogg.data = ByteBuffer.allocateDirect(data.length);
		ogg.data.put(data);
		ogg.data.rewind();
		
		return ogg;
	}
}
