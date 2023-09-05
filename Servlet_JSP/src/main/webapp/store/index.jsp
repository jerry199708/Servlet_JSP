<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <main>

        <div style="width:1000px;margin:0 auto;">
            <table>
              <tr>
                  <td rowspan="3" style="vertical-align: top;padding-top: 10px;">
                      <img src="https://cs-a.ecimg.tw/items/DHAK6QA9009Q2D6/000001_1547110244.jpg" width="200" style="padding-right: 20px;">
                  </td>
                  <td style="vertical-align: middle;height: 40px;">
                    <span style="color:blue">拼接美學 PIET系列造型時尚兩用包(黃色)</span>
                  </td>
                  <input type="hidden" >
              </tr>
              <tr>
                <td style="vertical-align: top;height: 120px;width:800px;">
				        1)幾何對比拼貼展開無限創意<BR>
						2)高密度尼龍面料，質感更加乘<BR>
						3)極致百搭，創造經典永恆
                </td>
              </tr>
              <tr>
                <td style="vertical-align: middle;text-align: right;">
                    <hr>
                    <b>價格：<span style="color:red">12,000</span></b>
                    <a href="index.html">
                        <img style="vertical-align: middle;" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4A1jV-g_TxYq3gIIuT76Tatt-iawfwsFmioSCYM_6wm--wRfk0eiOMQUMSdIpNBOq8vw&usqp=CAU" width="120">
                    </a>
                </td>
              </tr>
            </table>
        </div>

        <div style="width:1000px;margin:0 auto;">
            <table>
              <tr>
                  <td rowspan="3" style="vertical-align: top;padding-top: 10px;">
                      <img src="https://c.ecimg.tw/items/DEAINZA900B1LFY/000001_1607927024.jpg" width="200" style="padding-right: 20px;">
                  </td>
                  <td style="vertical-align: middle;height: 40px;">
                    <span style="color:blue">Balloon安撫搖椅探險版-小獅子</span>
                  </td>
              </tr>
              <tr>
                <td style="vertical-align: top;height: 120px;width:800px;">
                    ★可錄音可振動<BR>
                    ★三種使用模式、椅背四段調整<BR>
                    ★台灣總代理原廠公司貨<BR>
                    ★義大利十大知名品牌<BR>
                    ★其他顏色/款式可選★<BR>
                    ★安撫搖椅探險版-粉紅喵喵<BR>
                    ★安撫搖椅探險版-大象寶寶<BR>
                    ★安撫搖椅探險版-甜蜜貓熊<BR>
                    ★安撫搖椅探險版-田園藕灰<BR>
                    ★安撫搖椅探險版-小魚兒<BR>
                    ★安撫搖椅探險版-小狐狸<BR>
                    ★安撫搖椅探險版-小猴子<BR>
                    ★安撫搖椅探險版-小青蛙<BR>
                </td>
              </tr>
              <tr>
                <td style="vertical-align: middle;text-align: right;">
                    <hr>
                    <b>價格：<span style="color:red">8,800</span></b>
                    <FORM action="cart" method="POST">      
	              		<input type="hidden" name="proPic" value="https://c.ecimg.tw/items/DEAINZA900B1LFY/000001_1607927024.jpg">
	              		<input type="hidden" name="proName" value="Balloon安撫搖椅探險版-小獅子">
	              		<input type="hidden" name="proDescript" value="★三種使用模式、椅背四段調整">
	              		<input type="hidden" name="proPrice" value="12,000">
						<BUTTON TYPE="SUBMIT"><img style="vertical-align: middle;" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4A1jV-g_TxYq3gIIuT76Tatt-iawfwsFmioSCYM_6wm--wRfk0eiOMQUMSdIpNBOq8vw&usqp=CAU" width="120">放入購物車</BUTTON>
	              	</FORM>
                </td>
              </tr>
            </table>
        </div>

        <div style="width:1000px;margin:0 auto;">
            <table>
              <tr>
                  <td rowspan="3" style="vertical-align: top;padding-top: 10px;">
                      <img src="https://b.ecimg.tw/items/DHAS4NA900B7V2B/000002_1617190751.jpg" width="200" style="padding-right: 20px;">
                  </td>
                  <td style="vertical-align: middle;height: 40px;">
                    <span style="color:blue">【ROG Zephyrus】Zephyrus GA401QM-0032E5900HS 日蝕灰(有燈版)</span>
                  </td>
              </tr>
              <tr>
                <td style="vertical-align: top;height: 120px;;width:800px;">
                    ▃▅★ROG Zephyrus G14。強勢來襲★▅▃<BR>
					★全新顯卡視覺享受 RTX3060獨顯6G效能<BR>
					★超屌效能 搭載2021新世代 AMD Ryzen 9-5900HS 處理器<BR>
					★超狂容量 1TB M.2 NVMe™ PCIe® 3.0 SSD<BR>
					★14吋WQHD 120Hz IPS大屏佔比<BR>
					★Pantone®專業色彩認證 / PD3.0充電技術<BR>
					★輕薄美型 / 上蓋ROG動態編成LED技術<BR>
					★內建內建4喇叭+智慧放大技術<BR>
                </td>
              </tr>
              <tr>
                <td style="vertical-align: middle;text-align: right;">
                    <hr>
                    <b>價格：<span style="color:red">20,000</span></b>
              		<FORM action="cart" method="POST">      
	              		<input type="hidden" name="proPic" value="https://b.ecimg.tw/items/DHAS4NA900B7V2B/000002_1617190751.jpg">
	              		<input type="hidden" name="proName" value="▃▅★ROG Zephyrus G14。強勢來襲★▅▃">
	              		<input type="hidden" name="proDescript" value="★全新顯卡視覺享受 RTX3060獨顯6G效能">
	              		<input type="hidden" name="proPrice" value="20,000">
						<BUTTON TYPE="SUBMIT"><img style="vertical-align: middle;" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4A1jV-g_TxYq3gIIuT76Tatt-iawfwsFmioSCYM_6wm--wRfk0eiOMQUMSdIpNBOq8vw&usqp=CAU" width="120">放入購物車</BUTTON>
	              	</FORM>
                </td>
              </tr>
            </table>
        </div>
    </main>
  </body>
</html>