package java7.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 尝试java.nio包
 * Created by starqiu on 16-8-9.
 */
public class NIOTest {
    public static void main(String[] args) throws Exception{
        String filePath = "/home/workspace/starqiu/workspace/hiveData/T_QBPT_BJZDRY.txt";

        FileChannel channel = new RandomAccessFile(filePath,"rw").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.flip();
        int bufferRead = channel.read(buffer);
        while (bufferRead >=0){
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }
            buffer.clear();
            bufferRead = channel.read(buffer);
        }
    }

}
