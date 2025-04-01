package generated.grpc.userservice;

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
 * Service to register new users
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: UserLogin.proto")
public final class UserLoginGrpc {

  private UserLoginGrpc() {}

  public static final String SERVICE_NAME = "HowDoYouFeel.UserLogin";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.userservice.RegisterRequest,
      generated.grpc.userservice.RegisterResponse> getRegisterNewUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterNewUser",
      requestType = generated.grpc.userservice.RegisterRequest.class,
      responseType = generated.grpc.userservice.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.userservice.RegisterRequest,
      generated.grpc.userservice.RegisterResponse> getRegisterNewUserMethod() {
    io.grpc.MethodDescriptor<generated.grpc.userservice.RegisterRequest, generated.grpc.userservice.RegisterResponse> getRegisterNewUserMethod;
    if ((getRegisterNewUserMethod = UserLoginGrpc.getRegisterNewUserMethod) == null) {
      synchronized (UserLoginGrpc.class) {
        if ((getRegisterNewUserMethod = UserLoginGrpc.getRegisterNewUserMethod) == null) {
          UserLoginGrpc.getRegisterNewUserMethod = getRegisterNewUserMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.userservice.RegisterRequest, generated.grpc.userservice.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HowDoYouFeel.UserLogin", "RegisterNewUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.userservice.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.userservice.RegisterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserLoginMethodDescriptorSupplier("RegisterNewUser"))
                  .build();
          }
        }
     }
     return getRegisterNewUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.userservice.LoginRequest,
      generated.grpc.userservice.LoginResponse> getLoginUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoginUser",
      requestType = generated.grpc.userservice.LoginRequest.class,
      responseType = generated.grpc.userservice.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.userservice.LoginRequest,
      generated.grpc.userservice.LoginResponse> getLoginUserMethod() {
    io.grpc.MethodDescriptor<generated.grpc.userservice.LoginRequest, generated.grpc.userservice.LoginResponse> getLoginUserMethod;
    if ((getLoginUserMethod = UserLoginGrpc.getLoginUserMethod) == null) {
      synchronized (UserLoginGrpc.class) {
        if ((getLoginUserMethod = UserLoginGrpc.getLoginUserMethod) == null) {
          UserLoginGrpc.getLoginUserMethod = getLoginUserMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.userservice.LoginRequest, generated.grpc.userservice.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HowDoYouFeel.UserLogin", "LoginUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.userservice.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.userservice.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UserLoginMethodDescriptorSupplier("LoginUser"))
                  .build();
          }
        }
     }
     return getLoginUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserLoginStub newStub(io.grpc.Channel channel) {
    return new UserLoginStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserLoginBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserLoginBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserLoginFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserLoginFutureStub(channel);
  }

  /**
   * <pre>
   * Service to register new users
   * </pre>
   */
  public static abstract class UserLoginImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Register a new user with username and password &gt; use the Regex to validate 
     * </pre>
     */
    public void registerNewUser(generated.grpc.userservice.RegisterRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.userservice.RegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterNewUserMethod(), responseObserver);
    }

    /**
     * <pre>
     * Validate the username and password
     * </pre>
     */
    public void loginUser(generated.grpc.userservice.LoginRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.userservice.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterNewUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.userservice.RegisterRequest,
                generated.grpc.userservice.RegisterResponse>(
                  this, METHODID_REGISTER_NEW_USER)))
          .addMethod(
            getLoginUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.userservice.LoginRequest,
                generated.grpc.userservice.LoginResponse>(
                  this, METHODID_LOGIN_USER)))
          .build();
    }
  }

  /**
   * <pre>
   * Service to register new users
   * </pre>
   */
  public static final class UserLoginStub extends io.grpc.stub.AbstractStub<UserLoginStub> {
    private UserLoginStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserLoginStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserLoginStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserLoginStub(channel, callOptions);
    }

    /**
     * <pre>
     *Register a new user with username and password &gt; use the Regex to validate 
     * </pre>
     */
    public void registerNewUser(generated.grpc.userservice.RegisterRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.userservice.RegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterNewUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Validate the username and password
     * </pre>
     */
    public void loginUser(generated.grpc.userservice.LoginRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.userservice.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service to register new users
   * </pre>
   */
  public static final class UserLoginBlockingStub extends io.grpc.stub.AbstractStub<UserLoginBlockingStub> {
    private UserLoginBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserLoginBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserLoginBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserLoginBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Register a new user with username and password &gt; use the Regex to validate 
     * </pre>
     */
    public generated.grpc.userservice.RegisterResponse registerNewUser(generated.grpc.userservice.RegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterNewUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Validate the username and password
     * </pre>
     */
    public generated.grpc.userservice.LoginResponse loginUser(generated.grpc.userservice.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginUserMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service to register new users
   * </pre>
   */
  public static final class UserLoginFutureStub extends io.grpc.stub.AbstractStub<UserLoginFutureStub> {
    private UserLoginFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserLoginFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserLoginFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserLoginFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Register a new user with username and password &gt; use the Regex to validate 
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.userservice.RegisterResponse> registerNewUser(
        generated.grpc.userservice.RegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterNewUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Validate the username and password
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.userservice.LoginResponse> loginUser(
        generated.grpc.userservice.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_NEW_USER = 0;
  private static final int METHODID_LOGIN_USER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserLoginImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserLoginImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_NEW_USER:
          serviceImpl.registerNewUser((generated.grpc.userservice.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.userservice.RegisterResponse>) responseObserver);
          break;
        case METHODID_LOGIN_USER:
          serviceImpl.loginUser((generated.grpc.userservice.LoginRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.userservice.LoginResponse>) responseObserver);
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

  private static abstract class UserLoginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserLoginBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.userservice.UserServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserLogin");
    }
  }

  private static final class UserLoginFileDescriptorSupplier
      extends UserLoginBaseDescriptorSupplier {
    UserLoginFileDescriptorSupplier() {}
  }

  private static final class UserLoginMethodDescriptorSupplier
      extends UserLoginBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserLoginMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserLoginGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserLoginFileDescriptorSupplier())
              .addMethod(getRegisterNewUserMethod())
              .addMethod(getLoginUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}
