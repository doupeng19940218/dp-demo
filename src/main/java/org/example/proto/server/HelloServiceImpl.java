package org.example.proto.server;


import io.grpc.stub.StreamObserver;
import org.example.proto.HelloProto;
import org.example.proto.HelloServiceGrpc;


public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    /**
     * grpc 的返回值并不是通过Java中的返回值来返回。而是通过观察者设计模式通过参数返回的，后续会有详细的解释
     * 1. 接收客户端提交的参数
     * 2. 业务处理
     * 3. 返回处理结果
     *
     * @param request          req
     * @param responseObserver 响应观察者
     */
    @Override
    public void hello(HelloProto.HelloRequest request, StreamObserver<HelloProto.HelloResponse> responseObserver) {
        //1.接收client的请求参数
        String name = request.getName();
        //2.业务处理
        System.out.println("service name===>" + name);
        //3.封装响应
        //3.1 创建响应对象的构造者
        HelloProto.HelloResponse.Builder builder = HelloProto.HelloResponse.newBuilder();
        //3.2 填充数据
        builder.setResult("hello method invoke ok");
        //3.3 封装响应对象
        HelloProto.HelloResponse helloResponse = builder.build();
        //4.返回给客户端
        responseObserver.onNext(helloResponse);
        //5.通知客户端响应已结束
        responseObserver.onCompleted();
    }
}
