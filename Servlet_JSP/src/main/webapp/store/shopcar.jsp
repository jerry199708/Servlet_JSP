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
          <li onclick="location.href='index.html'">����</li>
          <li onclick="location.href='orders.html'">�q��d��</li>
          <li onclick="location.href='login.html'">�ʪ���</li>
        </ul>
      </nav>
    </div>
    <hr />
    <table>
      <thead>
        <tr>
          <th>�Ǹ�</th>
          <th>�ʶR�ӫ~</th>
          <th>���</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td><a href='index.html'>�������� PIET�t�C�y���ɩ|��Υ](����)</a></td>
          <td style="text-align: right;">12,000</td>
          <td><a href="shopcar.html">����</a></td>
        </tr>
        <tr>
          <td>2</td>
          <td><a href='index.html'>Balloon�w���n�ȱ��I��-�p��l</a></td>
          <td style="text-align: right;">8,000</td>
          <td><a href="shopcar.html">����</a></td>
        </tr>
        <tr>
          <td></td>
          <td></td>
          <td style="text-align: right;">�X�p���B�G<span style="color: red;">20,000</span></td>
          <td><button onclick="location.href='orders.html'">�T�{�q��</button></td>
        </tr>
      </tbody>
    </table>
  </body>
</html>