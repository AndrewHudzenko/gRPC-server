package org.example;

import com.andersen.grpc.GreetingServiceGrpc;
import com.andersen.grpc.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {

        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse.newBuilder()
                .setGreeting("Hello from server, " + request.getFirstName() + request.getSecondName())
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
