package decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteCountInputStrim extends FilterInputStream {

    private long readeBytes;

    protected ByteCountInputStrim(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int res = super.read();

        if(res >= 0){
            readeBytes++;
        }
        return res;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int res = super.read(b, off, len);
        if(res >= 0){
            readeBytes++;
        }
        return res;
    }

    public long getReadeBytes(){
        return  readeBytes;
    }

}
