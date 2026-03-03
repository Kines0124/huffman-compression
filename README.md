# 🗜️ Huffman Compression

A simple implementation of the **Huffman Compression Algorithm** in Java, developed for educational purposes.

---

## 📖 About

Huffman Coding is a lossless data compression algorithm that assigns shorter binary codes to more frequent characters and longer codes to less frequent ones. This project implements the full compression and decompression pipeline as a way to explore data structures like binary trees and priority queues.

---

## ✨ Features

- ✅ Build a Huffman Tree from input text
- ✅ Generate binary codes for each character
- ✅ Compress text using the generated codes
- ✅ Decompress binary data back to the original text

---

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- A terminal or an IDE (e.g. IntelliJ IDEA, Eclipse, VS Code)

### Cloning the repository

```bash
git clone https://github.com/Kines0124/huffman-compression.git
cd huffman-compression
```

### Compiling

```bash
javac -d out $(find src -name "*.java")
```

### Running

```bash
java -cp out Main
```

> ⚠️ The entry point and usage may vary depending on your implementation. Check the `src/` folder for the main class.

---

## 🧠 How It Works

1. **Frequency Analysis** — Count how many times each character appears in the input.
2. **Priority Queue** — Insert all characters into a min-heap ordered by frequency.
3. **Tree Construction** — Repeatedly merge the two nodes with the lowest frequency until only one tree remains.
4. **Code Generation** — Traverse the tree to assign a binary code to each character (left = `0`, right = `1`).
5. **Compression** — Replace each character in the input with its corresponding binary code.
6. **Decompression** — Use the Huffman Tree to decode the binary string back to the original text.

---

## 📂 Project Structure

```
huffman-compression/
├── src/
│   ├── BTree/
│   │   ├── BNode.java        # Huffman tree node
│   │   └── BTree.java        # Huffman tree structure
│   ├── data/
│   │   ├── conteudo.txt      # Input file (text to compress)
│   │   ├── conteudo.bin      # Compressed output (binary)
│   │   └── decodificado.txt  # Decompressed output
│   ├── decoder/
│   │   └── Decoder.java      # Decompression logic
│   ├── encoder/
│   │   └── Encoder.java      # Compression logic
│   ├── FileManager/
│   │   └── FileManager.java  # File read/write utilities
│   └── Main.java             # Entry point
├── .gitignore
└── README.md
```

---

## 📚 Learning Goals

This project was built to practice:

- Binary Trees and tree traversal
- Priority Queues (Min-Heap)
- Greedy algorithms
- Bit manipulation concepts

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
