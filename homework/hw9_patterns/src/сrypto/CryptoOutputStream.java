package сrypto;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoOutputStream extends FilterOutputStream{

    private byte[] password;
    private int count;

    protected CryptoOutputStream(OutputStream out, byte[] password){
        super(out);
        this.password = password;
        count = 0;
    }

    private byte encode(byte data){
           byte res = (byte) (data ^ password[count++%password.length]);
        return res;
    }

    @Override
    public void write(int b) throws IOException {
        int temp = encode((byte) b);
        super.write(temp);
    }

}
