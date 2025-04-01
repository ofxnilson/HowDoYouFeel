package generated.grpc.motivationalmessages;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service definition for sending motivational messages to the user throughout the day
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: MotivationalMessages.proto")
public final class MotivationalMessagesGrpc {

  private MotivationalMessagesGrpc() {}

  public static final String SERVICE_NAME = "HowDoYouFeel.MotivationalMessages";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.motivationalmessages.MotivationRequest,
      generated.grpc.motivationalmessages.MotivationResponse> getMotivationalMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MotivationalMessages",
      requestType = generated.grpc.motivationalmessages.MotivationRequest.class,
      responseType = generated.grpc.motivationalmessages.MotivationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.motivationalmessages.MotivationRequest,
      generated.grpc.motivationalmessages.MotivationResponse> getMotivationalMessagesMethod() {
    io.grpc.MethodDescriptor<generated.grpc.motivationalmessages.MotivationRequest, generated.grpc.motivationalmessages.MotivationResponse> getMotivationalMessagesMethod;
    if ((getMotivationalMessagesMethod = MotivationalMessagesGrpc.getMotivationalMessagesMethod) == null) {
      synchronized (MotivationalMessagesGrpc.class) {
        if ((getMotivationalMessagesMethod = MotivationalMessagesGrpc.getMotivationalMessagesMethod) == null) {
          MotivationalMessagesGrpc.getMotivationalMessagesMethod = getMotivationalMessagesMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.motivationalmessages.MotivationRequest, generated.grpc.motivationalmessages.MotivationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "HowDoYouFeel.MotivationalMessages", "MotivationalMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.motivationalmessages.MotivationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.motivationalmessages.MotivationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MotivationalMessagesMethodDescriptorSupplier("MotivationalMessages"))
                  .build();
          }
        }
     }
     return getMotivationalMessagesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MotivationalMessagesStub newStub(io.grpc.Channel channel) {
    return new MotivationalMessagesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MotivationalMessagesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MotivationalMessagesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MotivationalMessagesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MotivationalMessagesFutureStub(channel);
  }

  /**
   * <pre>
   * Service definition for sending motivational messages to the user throughout the day
   * </pre>
   */
  public static abstract class MotivationalMessagesImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Streams motivational messages throughout the day
     * </pre>
     */
    public void motivationalMessages(generated.grpc.motivationalmessages.MotivationRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.motivationalmessages.MotivationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMotivationalMessagesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMotivationalMessagesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                generated.grpc.motivationalmessages.MotivationRequest,
                generated.grpc.motivationalmessages.MotivationResponse>(
                  this, METHODID_MOTIVATIONAL_MESSAGES)))
          .build();
    }
  }

  /**
   * <pre>
   * Service definition for sending motivational messages to the user throughout the day
   * </pre>
   */
  public static final class MotivationalMessagesStub extends io.grpc.stub.AbstractStub<MotivationalMessagesStub> {
    private MotivationalMessagesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MotivationalMessagesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MotivationalMessagesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MotivationalMessagesStub(channel, callOptions);
    }

    /**
     * <pre>
     * Streams motivational messages throughout the day
     * </pre>
     */
    public void motivationalMessages(generated.grpc.motivationalmessages.MotivationRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.motivationalmessages.MotivationResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getMotivationalMessagesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service definition for sending motivational messages to the user throughout the day
   * </pre>
   */
  public static final class MotivationalMessagesBlockingStub extends io.grpc.stub.AbstractStub<MotivationalMessagesBlockingStub> {
    private MotivationalMessagesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MotivationalMessagesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MotivationalMessagesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MotivationalMessagesBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Streams motivational messages throughout the day
     * </pre>
     */
    public java.util.Iterator<generated.grpc.motivationalmessages.MotivationResponse> motivationalMessages(
        generated.grpc.motivationalmessages.MotivationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getMotivationalMessagesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service definition for sending motivational messages to the user throughout the day
   * </pre>
   */
  public static final class MotivationalMessagesFutureStub extends io.grpc.stub.AbstractStub<MotivationalMessagesFutureStub> {
    private MotivationalMessagesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MotivationalMessagesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MotivationalMessagesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MotivationalMessagesFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MOTIVATIONAL_MESSAGES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MotivationalMessagesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MotivationalMessagesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MOTIVATIONAL_MESSAGES:
          serviceImpl.motivationalMessages((generated.grpc.motivationalmessages.MotivationRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.motivationalmessages.MotivationResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MotivationalMessagesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MotivationalMessagesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.motivationalmessages.MotivationalMessagesImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MotivationalMessages");
    }
  }

  private static final class MotivationalMessagesFileDescriptorSupplier
      extends MotivationalMessagesBaseDescriptorSupplier {
    MotivationalMessagesFileDescriptorSupplier() {}
  }

  private static final class MotivationalMessagesMethodDescriptorSupplier
      extends MotivationalMessagesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MotivationalMessagesMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MotivationalMessagesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MotivationalMessagesFileDescriptorSupplier())
              .addMethod(getMotivationalMessagesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
