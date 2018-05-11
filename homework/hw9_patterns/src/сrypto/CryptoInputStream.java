package сrypto;

import java.io.*;

public class CryptoInputStream extends FilterInputStream{

    private byte[] password;
    
    protected CryptoInputStream(InputStream in, byte[] password) throws IOException {
        super(in);
        this.password = password;
    }
    
    private byte[] encode(byte[] data){
        byte[]res = new byte[data.length];
        for(int i = 0; i< data.length; i++){
            res[i] = (byte) (data[i] ^ password[i%password.length]);
        }
        return res;
    }

    @Override
    public int read() throws IOException {
        byte[] res = new byte[1];
        res[0] = (byte)super.read();
        if (res[0] != -1 ) res = encode(res);
        return res[0];
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int by;
        by = super.read(b, off, len);
        byte[] temp = encode(b);
        System.arraycopy(temp,0,b,0,temp.length);
        return by;
    }

    @Override
    public int read(byte[] b) throws IOException {
        return this.read(b,0,b.length);
    }
    
}
