# 🔑 Encryption Decryption

## 📝 Description

Command-line application that can encrypt or decrypt plaintext using one of two cipher algorithms:

- **Ceasar Cipher (Shift Cipher)**: Named after Julius Caesar, it shifts each letter of plaintext by the provided key according to its order in the alphabet (in circle).
- **Unicode Cipher**: It shifts each letter of plaintext by the provided key according to the Unicode table.

## 🕹️ Usage

| Arg   | Value(s)         | Description                   |
| ----- | ---------------- | ----------------------------- |
| -mode | enc or dec       | Used to encode or decode data |
| -key  | Integer          | Used by cipher algorithm      |
| -data | String           | Text from command-line        |
| -in   | String           | Filename to read text from    |
| -out  | String           | Filename to output text to    |
| -alg  | shift or unicode | Type of encryption            |
