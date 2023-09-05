<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
  <head>
    <style>
      * {
        transition: all 0.3s ease-in-out;
      }

      .container {
        clear: both;
        overflow: auto;
      }

      nav {
        float: right;
      }

      .logo img {
        float: left;
      }

      ul li {
        display: inline-block;
        padding: 10px;
        font-size: 20px;
        font-family: raleway;
      }

      ul li:hover {
        color: red;
      }

      table,
      th,
      td {
        border: solid 1px #000;
        padding: 10px;
      }

      table {
        border-collapse: collapse;
        caption-side: bottom;
        width: 100%;
      }

      caption {
        font-size: 16px;
        font-weight: bold;
        padding-top: 5px;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="logo">
        <img
          src="https://atimetoshop.com/wp-content/uploads/2019/06/A-time-to-shop-Logo.png"
          alt=""
          width="200"
        />
      </div>
      <nav>
        <ul>
          <li onclick="location.href='index.html'">首頁</li>
          <li onclick="location.href='orders.html'">訂單查詢</li>
          <li onclick="location.href='login.html'">購物車</li>
        </ul>
      </nav>
    </div>
    <hr />
    <table>
      <thead>
        <tr>
          <th>訂單編號</th>
          <th>訂單日期</th>
          <th>訂單金額</th>
          <th>訂單狀態</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>P12312413124</td>
          <td>2021-10-22 14:32:12</td>
          <td style="text-align: right;">20,000</td>
          <td style="text-align: right;">成立</td>
          <td><button onclick="location.href='shopcar.html'">訂單明細</button>&nbsp;<button onclick="location.href='orders.html'">訂單取消</button></td>
        </tr>
        <tr>
          <td>P1231241331</td>
          <td>2021-10-23 11:37:09</td>
          <td style="text-align: right;">10,000</td>
          <td style="text-align: right;">成立</td>
          <td><button onclick="location.href='shopcar.html'">訂單明細</button>&nbsp;<button onclick="location.href='orders.html'">訂單取消</button></td>
        </tr>
      </tbody>
    </table>
  </body>
</html>