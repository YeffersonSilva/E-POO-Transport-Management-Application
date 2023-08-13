# E-POO Transport Management Application

This Java application is designed to manage the transportation of goods for the E-POO Transport company.

## Features

1. **Data Input:**
   - Sender's Name
   - Recipient's Name
   - Cargo Volume (m³)
   - Distance: HardCoded distances for local city to destinations (Bagé, Pelotas, Rio Grande).
   
2. **Register Trip:**
   - Input data organized into Transporter class objects.
   - All objects stored in an ArrayList.
   - Data stored in cargasRecebidas.csv.
   - Display data in a TextArea, ordered by registration.

3. **Close Cargo:**
   - Assemble truck's cargo (max 50m³) from memory.
   - Cargo removal follows rules to not exceed 50m³ and prioritize oldest cargos.
   - Create caminhao.csv for compliant cargos, remove from ArrayList and cargasRecebidas.csv.

## Tags

Tag and categorize this repository with the following:

- Java
- Transportation Management
- Data Handling
- ArrayList
- File Handling
