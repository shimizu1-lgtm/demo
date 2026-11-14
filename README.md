# 📦 在庫管理システム（Inventory Management System）

Spring Boot と Thymeleaf を用いて作成した、シンプルなWeb在庫管理アプリケーションです。
商品の登録、一覧表示、入庫（+1）・出庫（-1）による在庫数のリアルタイム更新、および在庫状況のアラート表示が可能です。

## 主な機能
- **商品新規登録**：商品名と初期在庫数を入力してデータベースへ登録
- **在庫一覧表示**：登録済み商品の一覧と現在の在庫数を表示
- **入出庫管理**：「＋入庫」「ー出庫」ボタンによるワンクリックでの在庫増減（在庫0未満にならないよう制御）
- **在庫ステータス自動判定**：
  - 在庫 4個以上：通常表示
  - 在庫 1〜3個：黄色バッジで「残りわずか（要発注）」と警告表示
  - 在庫 0個：赤色バッジで「在庫切れ」と表示し、出庫ボタンを無効化
- **商品削除**：不要になった商品データの削除

## 使用技術
- **言語**：Java 21
- **フレームワーク**：Spring Boot 3 (Spring Web / Spring Data JPA / Thymeleaf)
- **データベース**：H2 Database（インメモリDB）
- **ビルドツール**：Maven
- **開発環境**：Visual Studio Code / Git / GitHub

## ローカル環境での起動方法
1. リポジトリをクローンします。
   ```bash
   git clone [https://github.com/shimizu1-lgtm/demo.git](https://github.com/shimizu1-lgtm/demo.git)
