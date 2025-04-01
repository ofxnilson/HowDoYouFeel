// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SentimentService.proto

package generated.grpc.sentimentanalysis;

public interface ChatRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:HowDoYouFeel.ChatRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * ID to identify the user
   * </pre>
   *
   * <code>string user_id = 1;</code>
   */
  java.lang.String getUserId();
  /**
   * <pre>
   * ID to identify the user
   * </pre>
   *
   * <code>string user_id = 1;</code>
   */
  com.google.protobuf.ByteString
      getUserIdBytes();

  /**
   * <pre>
   * User's message to the chatbot
   * </pre>
   *
   * <code>string message = 2;</code>
   */
  java.lang.String getMessage();
  /**
   * <pre>
   * User's message to the chatbot
   * </pre>
   *
   * <code>string message = 2;</code>
   */
  com.google.protobuf.ByteString
      getMessageBytes();
}
