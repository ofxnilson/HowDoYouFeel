package mainServerClientGUI;

import generated.grpc.sentimentanalysis.SentimentRequest;
import generated.grpc.sentimentanalysis.SentimentResponse;
import generated.grpc.sentimentanalysis.SentimentServiceGrpc;
import generated.grpc.motivationalmessages.MotivationalMessagesGrpc;
import generated.grpc.motivationalmessages.MotivationalMessagesGrpc.MotivationalMessagesStub;
import generated.grpc.motivationalmessages.MotivationRequest;
import generated.grpc.motivationalmessages.MotivationResponse;
import io.grpc.stub.StreamObserver;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 * @author Nilson Francisco
 */
public class MainAppFrame extends javax.swing.JFrame {
    private final int userId;
    private final SentimentServiceGrpc.SentimentServiceBlockingStub sentimentStub;
    private final SentimentServiceGrpc.SentimentServiceStub sentimentAsyncStub;
    private boolean isMotivationOn = false;   
    private MotivationalMessagesStub motivationalStub;
    /**
     * Creates new form MainAppFrame
     * @param userId
     * @param sentimentStub
     * @param motivationalStub
     */
    public MainAppFrame(int userId, SentimentServiceGrpc.SentimentServiceBlockingStub sentimentStub, SentimentServiceGrpc.SentimentServiceStub sentimentAsyncStub, MotivationalMessagesGrpc.MotivationalMessagesStub motivationalStub){
        initComponents();
        this.userId = userId;
        this.sentimentStub = sentimentStub;
        this.sentimentAsyncStub = sentimentAsyncStub;
        this.motivationalStub = motivationalStub;
        comboTimeOfDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Morning", "Afternoon", "Night"}));
        boostFreq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"5sec", "30sec", "1min"}));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textSentiment = new javax.swing.JTextArea();
        comboTimeOfDay = new javax.swing.JComboBox<>();
        activityDone = new javax.swing.JTextField();
        saveMood = new javax.swing.JButton();
        chatBot = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        weeklyReport = new javax.swing.JButton();
        motivationalMessages = new javax.swing.JCheckBox();
        boostFreq = new javax.swing.JComboBox<>();
        gratitude = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sentiment Analisys");

        jLabel1.setFont(new java.awt.Font("sansserif", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("How do you feel");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Right now, I feel...");

        textSentiment.setColumns(20);
        textSentiment.setRows(5);
        jScrollPane1.setViewportView(textSentiment);

        comboTimeOfDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTimeOfDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTimeOfDayActionPerformed(evt);
            }
        });

        activityDone.setText("When I did...");
        activityDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityDoneActionPerformed(evt);
            }
        });

        saveMood.setText("Save my mood");
        saveMood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMoodActionPerformed(evt);
            }
        });

        chatBot.setText("ChatBot");
        chatBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatBotActionPerformed(evt);
            }
        });

        weeklyReport.setText("Report");
        weeklyReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weeklyReportActionPerformed(evt);
            }
        });

        motivationalMessages.setText("MoodBoost");
        motivationalMessages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivationalMessagesActionPerformed(evt);
            }
        });

        boostFreq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boostFreq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boostFreqActionPerformed(evt);
            }
        });

        gratitude.setText("Be grateful");
        gratitude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gratitudeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboTimeOfDay, 0, 86, Short.MAX_VALUE)
                                    .addComponent(weeklyReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(activityDone)
                                    .addComponent(saveMood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jSeparator1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(motivationalMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gratitude, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatBot, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(boostFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTimeOfDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activityDone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveMood)
                    .addComponent(weeklyReport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chatBot)
                    .addComponent(gratitude))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boostFreq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motivationalMessages))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboTimeOfDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTimeOfDayActionPerformed

    }//GEN-LAST:event_comboTimeOfDayActionPerformed

    private void weeklyReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weeklyReportActionPerformed
        JDialog dialog = new JDialog(this, "Weekly Mood Report", true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(new MyReport(userId));
        dialog.setSize(850, 500);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_weeklyReportActionPerformed

    private void saveMoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMoodActionPerformed
        try{
            // Read user inputs
            String text = textSentiment.getText().trim();
            String timeOfDay = comboTimeOfDay.getSelectedItem().toString();
            String activity = activityDone.getText().trim();
            
            // Check if the user have entered all the info that I need in the report
            if (text.isEmpty() || activity.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter your sentiment and what happened that made you feel that way");
                return;
            }

            // Create the request
            SentimentRequest request = SentimentRequest.newBuilder().setUserId(userId).setText(text).setTimeOfDay(timeOfDay).setActivity(activity).build();

            // Send request and get response
            SentimentResponse response;
                response = sentimentStub.analyseSaveSentiment(request);
                
            // Save the user inputs to a .csv file to keep track and analyse and clear the form for a new entry
            saveToCsv(text, response.getSentiment(), response.getConfidence(), timeOfDay, activity);
           
            textSentiment.setText("");
            activityDone.setText("");
            comboTimeOfDay.setSelectedIndex(0);
            
            // Confirm that the sentiment was saved
            JOptionPane.showMessageDialog(this, "Thanks for sharing your sentiments with me!\n I hope you are great today!");    

        } 
        catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error analyzing sentiment: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveMoodActionPerformed

    // Button to popup the chatBot
    private void chatBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatBotActionPerformed
        ChatBot chatPopup = new ChatBot(this, true, sentimentAsyncStub); 
        chatPopup.setVisible(true); 
    }//GEN-LAST:event_chatBotActionPerformed

    private void activityDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityDoneActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_activityDoneActionPerformed

    private void motivationalMessagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivationalMessagesActionPerformed
        // Start streaming motivational messages acording to the selection time
        if (!isMotivationOn){
            String selected = (String) boostFreq.getSelectedItem();
            int delay;
            switch (selected){
                case "5sec":
                    delay = 5000;
                    break;
                case "30sec":
                    delay = 30000;
                    break;
                case "1min":
                    delay = 60000;
                    break;
                default:
                    delay = 10000;
                    break;
            }
            isMotivationOn = true;
            
            new Thread(() ->{
                try{
                    motivationalStub.motivationalMessages(MotivationRequest.newBuilder().setUserId(userId).build(),
                        new StreamObserver<MotivationResponse>(){
                            @Override
                            public void onNext(MotivationResponse response){
                                if (!isMotivationOn) return;
                                SwingUtilities.invokeLater(() ->{
                                    JOptionPane.showMessageDialog(MainAppFrame.this, response.getMessage(), "Motivational Message", JOptionPane.INFORMATION_MESSAGE);
                                });
                                try{
                                    Thread.sleep(delay);
                                } 
                                catch (InterruptedException ignored){
                                }
                            }
                            @Override
                             public void onError(Throwable t){
                                isMotivationOn = false;
                                SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(MainAppFrame.this, "Error receiving messages: " + t.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                                }
                                @Override
                                public void onCompleted(){
                                }
                            }
                        );
                    } 
                    catch (Exception e){
                        isMotivationOn = false;
                        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(MainAppFrame.this, "Failed to start motivational messages.", "Error", JOptionPane.ERROR_MESSAGE));
                    }
            }).start();
        } 
        else{
            isMotivationOn = false;
            JOptionPane.showMessageDialog(this, "Motivational Messages Disabled");
        }
    }//GEN-LAST:event_motivationalMessagesActionPerformed

    private void boostFreqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boostFreqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boostFreqActionPerformed

    private void gratitudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gratitudeActionPerformed
        Gratitude gratitudePopup = new Gratitude(this, true, userId, motivationalStub); 
        gratitudePopup.setVisible(true);
    }//GEN-LAST:event_gratitudeActionPerformed

    // Helper method to save the user entries to the .csv file
    private void saveToCsv(String text, String sentiment, float confidence, String timeOfDay, String activity){
        String filePath = "data/tracker/usersMoods.csv";
        File file = new File(filePath);

        try (FileWriter writer = new FileWriter(filePath, true)) {
            if (file.length() == 0){
                writer.append("Date,UserID,Text,Sentiment,Confidence,TimeOfDay,Activity\n");
            }

            String date = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            writer.append(String.format("\"%s\",\"%s\",\"%s\",\"%s\",%.2f,\"%s\",\"%s\"\n", date, userId, text.replace("\"", "\"\""), sentiment, confidence, timeOfDay, activity.replace("\"", "\"\"")));
        } 
        catch (IOException e){
            JOptionPane.showMessageDialog(this, "Failed to save mood data: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField activityDone;
    private javax.swing.JComboBox<String> boostFreq;
    private javax.swing.JButton chatBot;
    private javax.swing.JComboBox<String> comboTimeOfDay;
    private javax.swing.JButton gratitude;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox motivationalMessages;
    private javax.swing.JButton saveMood;
    private javax.swing.JTextArea textSentiment;
    private javax.swing.JButton weeklyReport;
    // End of variables declaration//GEN-END:variables
}
