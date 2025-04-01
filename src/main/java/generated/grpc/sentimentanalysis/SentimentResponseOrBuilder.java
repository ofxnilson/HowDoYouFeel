// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SentimentService.proto

package generated.grpc.sentimentanalysis;

public interface SentimentResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:HowDoYouFeel.SentimentResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Detected sentiment (positive, negative or neutral)
   * </pre>
   *
   * <code>string sentiment = 1;</code>
   */
  java.lang.String getSentiment();
  /**
   * <pre>
   * Detected sentiment (positive, negative or neutral)
   * </pre>
   *
   * <code>string sentiment = 1;</code>
   */
  com.google.protobuf.ByteString
      getSentimentBytes();

  /**
   * <pre>
   * Confidence score of the sentiment analysis
   * </pre>
   *
   * <code>float confidence = 2;</code>
   */
  float getConfidence();
}
