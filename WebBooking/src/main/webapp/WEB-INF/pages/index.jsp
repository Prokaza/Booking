<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title><spring:message code="message.title" /></title>
  <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" >
  <link rel="shortcut icon" href="/resources/image/bike-ico.png" type="image/png">
  <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />" type=""></script>
</head>
<body>
<div id="container">
  <%@include file="/WEB-INF/pages/include/header.jsp"%>
    <%@include file="/WEB-INF/pages/include/main_menu.jsp"%>
    <div id="content">
      <h1 id="font_black">Катайся на велосипеде вместе c нами</h1>
      <img id="image_main" alt="Польза велосипеда" src=<c:url value="/resources/image/main_pic_01.jpg"/> >
      <table>
        <tr>
          <td id="ico">
            <img  alt="Польза велосипеда" src=<c:url value="/resources/image/ico01.png"/> >
          </td>
          <td id="main_text">
            <h2 id="font_green">Полезно для здоровья</h2>
            <p>Каждый с детства знает, что полезно кушать фрукты, каши и дышать свежим воздухом.
              Знаем, однако следуем ли мы всем этим правилам?Катание на велосипеде помогает органично
              вписать ежедневные тренировки в ежедневный график. Вы будете в тонусе и отличной форме.
              А правильные физические нагрузки влияют на формирование здорового рациона, нормализацию сна.
              Ведь все мы хотим быть счастливыми и удачными в жизни.  Именно с велосипедом
              у вас хватит здоровья на свершение даже самых непостежимых высот.</p></td>
        </tr>
        <tr>
          <td id="ico">
            <img alt="Польза велосипеда" src=<c:url value="/resources/image/ico02.png"/> >
          </td>
          <td id="main_text">
            <h2 id="font_orange">Дешевле, чем на машине</h2>
            <p>Начать колесить на велике намного проще, чем кажется.
              Стоит один раз попробовать и уже не возможно представить свою жизнь без двухколесного брата по духу.
              На первых порах непременно попробуйте прокат велосипедов.
              Таким образом, вы сможете в полной мере оттестировать какой тип велосипеда подойдет именно вам.
              Может это будет универсальный горный велик, которому нипочем горбистая местность.
              Может вы влюбитесь в шикарный дорожный велосипед с удобным сидением, комфортным
              расположением каждой детали и гламурными элементами, как то корзинка, звонок и др.
              Или вы откроете в себе фаната шоссейных велосипедов, который обожает скорость и мчится
              навстречу новым приключениям.Велосипед - транспорт для романтиков. А ведь именно они и покоряют мир!</p>
        </tr>
        <tr>
          <td id="ico">
            <img alt="Польза велосипеда" src=<c:url value="/resources/image/ico03.png"/> >
          </td>
          <td id="main_text">
            <h2 id="font_blue">Безопасно для окружающей среды</h2>
            <p>Лучший способ преобразить мир - начать совершать значимые поступки для всей планеты.
              Природа - источник нашей энергии, силы и вдохновения. Поэтому так важно оберегать, холить и лелеять ее.
              Кто-то садит новые деревья, кто-то облагораживает участок возле дома цветами,
              а кто-то сможет сделать великое дело, если будет их просто беречь.</p>
        </tr>
        <tr>
          <td id="ico">
            <img alt="Польза велосипеда" src=<c:url value="/resources/image/ico04.png"/> >
          </td>
          <td id="main_text">
            <h2 id="font_green">Дарит заряд позитивных эмоций</h2>
            <p>Самый весомый аргумент в защиту пользы проката на велосипеде - это
              неиссякаемая подзарядка позитивом.Секрет кроется в особой атмосфере этого хулигана.
              Именно велосипед способен вызывать тебя хоть каждый день на бой с самим собой.
              Каждый день новые свершения, которые завтра превратятся в пройденный этап.
              Чем больше ты катаешься, тем больше у тебя желания совершать новые заезды, рывки и покорять новые киллометры.
              А ведь именно от желания у человека появляется искра в глазах. </p>
          </td>
        </tr>
      </table>
      <img id="image_main" alt="Польза велосипеда" src=<c:url value="/resources/image/main_pic_02.jpg"/> >
    </div>
  <%@include file="/WEB-INF/pages/include/footer.jsp"%>
</div>
</body>
</html>
