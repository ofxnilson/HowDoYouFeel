# HowDoYouFeel – Sentiment Analysis & Wellness System

A distributed client–server Java application that analyzes user mood, stores daily sentiment entries, and provides real-time motivational support using gRPC streaming.

This project demonstrates networking, concurrent systems, and GUI development.

---

## Features

- User registration and login
- Daily mood entry (morning / afternoon / night)
- Sentiment analysis classification (positive / negative)
- Weekly sentiment report generation
- Server-streaming motivational messages
- Bidirectional chatbot for emotional support
- Java Swing desktop GUI
- Automatic server discovery using JmDNS

---

## Architecture

Client (Swing GUI)  
⬇  
gRPC Services  
⬇  
Server (Business logic + storage)

### gRPC Services
- Unary RPC → Save & analyze sentiment
- Server streaming → Motivational messages
- Client streaming → Gratitude journaling
- Bidirectional streaming → Chatbot

---

## Tech Stack

- Java
- gRPC
- Protocol Buffers
- Java Swing
- Maven
- Networking fundamentals

---

## How to Run

### 1. Clone
git clone https://github.com/ofxnilson/HowDoYouFeel

### 2. Build
mvn clean install

### 3. Start server
Run ServerMain

### 4. Start client
Run ClientMain

---

## What I Learned

- Designing distributed systems with RPC
- Streaming communication patterns
- GUI integration with backend services
- Concurrency and client handling
- Service-oriented architecture

---

## Screenshots
!!!! To be added !!!!
