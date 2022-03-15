<%--
  Created by IntelliJ IDEA.
  User: 2016WUJI01-XIAOXIN
  Date: 2022/3/14
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <div class="container">
        <nav class="navbar navbar-default" role="navigation">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/index">首页</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">商品分类<b
                            class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-2">
                            <li>
                                <div class="row">
                                    <div class="col-sm-12"><h4>商品分类</h4></div>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li><a href="#">热销</a></li>
                    <li><a href="#">新品</a></li>
                    <li><a href="#" class="active">注册</a></li>
                    <li><a href="#">登录</a></li>
                </ul>
            </div>
        </nav>
        <div class="header-info">
            <div class="header-right search-box"><a href="javascript:;"><span class="glyphicon glyphicon-search"
                                                                              aria-hidden="true"></span></a>
                <div class="search">
                    <form action="/" class="navbar-form"><input type="text" class="form-control" name="keyword">
                        <button type="submit" class="btn btn-default" aria-label="LeftAlign">搜索</button>
                    </form>
                </div>
            </div>
            <div class="header-right cart">
                <a href="goods_cart.jsp"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"><span
                        class="card_num"></span></span></a>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>