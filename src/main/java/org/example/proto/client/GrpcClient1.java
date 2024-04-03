package org.example.proto.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.proto.HelloProto;
import org.example.proto.HelloServiceGrpc;

/**
 * @author walker.dou
 */
public class GrpcClient1 {
    public static void main(String[] args) {
        //1.创建通信的管道
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();
        try {
            //2.获得代理对象 stub
            HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub = HelloServiceGrpc.newBlockingStub(managedChannel);
            //3.完成rpc调用
            //3.1 准备参数
            HelloProto.HelloRequest.Builder builder = HelloProto.HelloRequest.newBuilder();
            builder.setName("WangZe");
            HelloProto.HelloRequest helloRequest = builder.build();
            //3.2 rpc请求
            HelloProto.HelloResponse helloResponse = helloServiceBlockingStub.hello(helloRequest);
            //3.3 记牌器瞎忙活忙活没人品冒号
            String result = helloResponse.getResult();
            System.out.println("rpc响应内容==》" + result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            managedChannel.shutdown();
        }
    }
}