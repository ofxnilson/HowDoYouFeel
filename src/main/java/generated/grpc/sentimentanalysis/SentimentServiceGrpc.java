package generated.grpc.sentimentanalysis;

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
 * Service definition for analyzing user sentiment and provide chatbot
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: SentimentService.proto")
public final class SentimentServiceGrpc {

  private SentimentServiceGrpc() {}

  public static final String SERVICE_NAME = "HowDoYouFeel.SentimentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.sentimentanalysis.SentimentRequest,
      generated.grpc.sentimentanalysis.SentimentResponse> getAnalyseSaveSentimentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyseSaveSentiment",
      requestType = generated.grpc.sentimentanalysis.SentimentRequest.class,
      responseType = generated.grpc.sentimentanalysis.SentimentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.sentimentanalysis.SentimentRequest,
      generated.grpc.sentimentanalysis.SentimentResponse> getAnalyseSaveSentimentMethod() {
    io.grpc.MethodDescriptor<generated.grpc.sentimentanalysis.SentimentRequest, generated.grpc.sentimentanalysis.SentimentResponse> getAnalyseSaveSentimentMethod;
    if ((getAnalyseSaveSentimentMethod = SentimentServiceGrpc.getAnalyseSaveSentimentMethod) == null) {
      synchronized (SentimentServiceGrpc.class) {
        if ((getAnalyseSaveSentimentMethod = SentimentServiceGrpc.getAnalyseSaveSentimentMethod) == null) {
          SentimentServiceGrpc.getAnalyseSaveSentimentMethod = getAnalyseSaveSentimentMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.sentimentanalysis.SentimentRequest, generated.grpc.sentimentanalysis.SentimentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HowDoYouFeel.SentimentService", "AnalyseSaveSentiment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.sentimentanalysis.SentimentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.sentimentanalysis.SentimentResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SentimentServiceMethodDescriptorSupplier("AnalyseSaveSentiment"))
                  .build();
          }
        }
     }
     return getAnalyseSaveSentimentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.sentimentanalysis.WeeklyReportRequest,
      generated.grpc.sentimentanalysis.WeeklyReportResponse> getGetWeeklyReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWeeklyReport",
      requestType = generated.grpc.sentimentanalysis.WeeklyReportRequest.class,
      responseType = generated.grpc.sentimentanalysis.WeeklyReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.sentimentanalysis.WeeklyReportRequest,
      generated.grpc.sentimentanalysis.WeeklyReportResponse> getGetWeeklyReportMethod() {
    io.grpc.MethodDescriptor<generated.grpc.sentimentanalysis.WeeklyReportRequest, generated.grpc.sentimentanalysis.WeeklyReportResponse> getGetWeeklyReportMethod;
    if ((getGetWeeklyReportMethod = SentimentServiceGrpc.getGetWeeklyReportMethod) == null) {
      synchronized (SentimentServiceGrpc.class) {
        if ((getGetWeeklyReportMethod = SentimentServiceGrpc.getGetWeeklyReportMethod) == null) {
          SentimentServiceGrpc.getGetWeeklyReportMethod = getGetWeeklyReportMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.sentimentanalysis.WeeklyReportRequest, generated.grpc.sentimentanalysis.WeeklyReportResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "HowDoYouFeel.SentimentService", "GetWeeklyReport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.sentimentanalysis.WeeklyReportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.sentimentanalysis.WeeklyReportResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SentimentServiceMethodDescriptorSupplier("GetWeeklyReport"))
                  .build();
          }
        }
     }
     return getGetWeeklyReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.sentimentanalysis.ChatRequest,
      generated.grpc.sentimentanalysis.ChatResponse> getChatWithBotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChatWithBot",
      requestType = generated.grpc.sentimentanalysis.ChatRequest.class,
      responseType = generated.grpc.sentimentanalysis.ChatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.sentimentanalysis.ChatRequest,
      generated.grpc.sentimentanalysis.ChatResponse> getChatWithBotMethod() {
    io.grpc.MethodDescriptor<generated.grpc.sentimentanalysis.ChatRequest, generated.grpc.sentimentanalysis.ChatResponse> getChatWithBotMethod;
    if ((getChatWithBotMethod = SentimentServiceGrpc.getChatWithBotMethod) == null) {
      synchronized (SentimentServiceGrpc.class) {
        if ((getChatWithBotMethod = SentimentServiceGrpc.getChatWithBotMethod) == null) {
          SentimentServiceGrpc.getChatWithBotMethod = getChatWithBotMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.sentimentanalysis.ChatRequest, generated.grpc.sentimentanalysis.ChatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "HowDoYouFeel.SentimentService", "ChatWithBot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.sentimentanalysis.ChatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.sentimentanalysis.ChatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SentimentServiceMethodDescriptorSupplier("ChatWithBot"))
                  .build();
          }
        }
     }
     return getChatWithBotMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SentimentServiceStub newStub(io.grpc.Channel channel) {
    return new SentimentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SentimentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SentimentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SentimentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SentimentServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service definition for analyzing user sentiment and provide chatbot
   * </pre>
   */
  public static abstract class SentimentServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Analyses the sentiment on the typed text and save it
     * </pre>
     */
    public void analyseSaveSentiment(generated.grpc.sentimentanalysis.SentimentRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.sentimentanalysis.SentimentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAnalyseSaveSentimentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Return the weekly sentiment report
     * </pre>
     */
    public void getWeeklyReport(generated.grpc.sentimentanalysis.WeeklyReportRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.sentimentanalysis.WeeklyReportResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetWeeklyReportMethod(), responseObserver);
    }

    /**
     * <pre>
     * Bi-directional streaming for chatbot interaction that will simulate a human
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.sentimentanalysis.ChatRequest> chatWithBot(
        io.grpc.stub.StreamObserver<generated.grpc.sentimentanalysis.ChatResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getChatWithBotMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAnalyseSaveSentimentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.sentimentanalysis.SentimentRequest,
                generated.grpc.sentimentanalysis.SentimentResponse>(
                  this, METHODID_ANALYSE_SAVE_SENTIMENT)))
          .addMethod(
            getGetWeeklyReportMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.sentimentanalysis.WeeklyReportRequest,
                generated.grpc.sentimentanalysis.WeeklyReportResponse>(
                  this, METHODID_GET_WEEKLY_REPORT)))
          .addMethod(
            getChatWithBotMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                generated.grpc.sentimentanalysis.ChatRequest,
                generated.grpc.sentimentanalysis.ChatResponse>(
                  this, METHODID_CHAT_WITH_BOT)))
          .build();
    }
  }

  /**
   * <pre>
   * Service definition for analyzing user sentiment and provide chatbot
   * </pre>
   */
  public static final class SentimentServiceStub extends io.grpc.stub.AbstractStub<SentimentServiceStub> {
    private SentimentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SentimentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentimentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SentimentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Analyses the sentiment on the typed text and save it
     * </pre>
     */
    public void analyseSaveSentiment(generated.grpc.sentimentanalysis.SentimentRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.sentimentanalysis.SentimentResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnalyseSaveSentimentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Return the weekly sentiment report
     * </pre>
     */
    public void getWeeklyReport(generated.grpc.sentimentanalysis.WeeklyReportRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.sentimentanalysis.WeeklyReportResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetWeeklyReportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Bi-directional streaming for chatbot interaction that will simulate a human
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.sentimentanalysis.ChatRequest> chatWithBot(
        io.grpc.stub.StreamObserver<generated.grpc.sentimentanalysis.ChatResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getChatWithBotMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service definition for analyzing user sentiment and provide chatbot
   * </pre>
   */
  public static final class SentimentServiceBlockingStub extends io.grpc.stub.AbstractStub<SentimentServiceBlockingStub> {
    private SentimentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SentimentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentimentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SentimentServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Analyses the sentiment on the typed text and save it
     * </pre>
     */
    public generated.grpc.sentimentanalysis.SentimentResponse analyseSaveSentiment(generated.grpc.sentimentanalysis.SentimentRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnalyseSaveSentimentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return the weekly sentiment report
     * </pre>
     */
    public generated.grpc.sentimentanalysis.WeeklyReportResponse getWeeklyReport(generated.grpc.sentimentanalysis.WeeklyReportRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetWeeklyReportMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service definition for analyzing user sentiment and provide chatbot
   * </pre>
   */
  public static final class SentimentServiceFutureStub extends io.grpc.stub.AbstractStub<SentimentServiceFutureStub> {
    private SentimentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SentimentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SentimentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SentimentServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Analyses the sentiment on the typed text and save it
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.sentimentanalysis.SentimentResponse> analyseSaveSentiment(
        generated.grpc.sentimentanalysis.SentimentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnalyseSaveSentimentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Return the weekly sentiment report
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.sentimentanalysis.WeeklyReportResponse> getWeeklyReport(
        generated.grpc.sentimentanalysis.WeeklyReportRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetWeeklyReportMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANALYSE_SAVE_SENTIMENT = 0;
  private static final int METHODID_GET_WEEKLY_REPORT = 1;
  private static final int METHODID_CHAT_WITH_BOT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SentimentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SentimentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ANALYSE_SAVE_SENTIMENT:
          serviceImpl.analyseSaveSentiment((generated.grpc.sentimentanalysis.SentimentRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.sentimentanalysis.SentimentResponse>) responseObserver);
          break;
        case METHODID_GET_WEEKLY_REPORT:
          serviceImpl.getWeeklyReport((generated.grpc.sentimentanalysis.WeeklyReportRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.sentimentanalysis.WeeklyReportResponse>) responseObserver);
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
        case METHODID_CHAT_WITH_BOT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.chatWithBot(
              (io.grpc.stub.StreamObserver<generated.grpc.sentimentanalysis.ChatResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SentimentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SentimentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.sentimentanalysis.SentimentServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SentimentService");
    }
  }

  private static final class SentimentServiceFileDescriptorSupplier
      extends SentimentServiceBaseDescriptorSupplier {
    SentimentServiceFileDescriptorSupplier() {}
  }

  private static final class SentimentServiceMethodDescriptorSupplier
      extends SentimentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SentimentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SentimentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SentimentServiceFileDescriptorSupplier())
              .addMethod(getAnalyseSaveSentimentMethod())
              .addMethod(getGetWeeklyReportMethod())
              .addMethod(getChatWithBotMethod())
              .build();
        }
      }
    }
    return result;
  }
}
