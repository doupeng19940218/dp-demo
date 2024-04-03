package org.example.proto.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author walker.dou
 */
public class GrpcServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        //1.设置端口
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(9000);
        //2.发布服务
        serverBuilder.addService(new HelloServiceImpl());
        //3.创建服务对象
        Server server = serverBuilder.build();
        //4.启动服务器
        server.start();
        server.awaitTermination();

    }
}

