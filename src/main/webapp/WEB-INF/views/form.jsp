<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="../../resources/css/style.css"/>"/>
</head>
<body>
<jsp:include page="header.jsp"/>


<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną organizację, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form action="/donation/form" method="post" modelAttribute="donation">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>
            <c:forEach items="${categoryList}" var="category" >
                <div class="form-group form-group--checkbox">
                    <label>
                        <form:checkbox id="categories" path="categoryList"  value="${category.id}" />
                        <span class="checkbox"></span>
                        <span class="description">${category.name}</span>
                    </label>
                </div>
            </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input  id="quantity" path = "quantity"/>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>



            <!-- STEP 4 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>
                <c:forEach items="${institutionList}" var="institution" >
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:radiobutton id="institution" path="institution"  value="${institution.id}" />
                            <span class="checkbox radio"></span>
                            <span class="description">
                          <div class="title">${institution.name}</div>
                          <div class="subtitle">${institution.description}</div>
                            </span>
                        </label>
                    </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica <form:input id="street" path = "street" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto <form:input id="city" path = "city" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy <form:input   id="zipCode" path = "zipCode"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <input type="number" name="phone" id="phone"/>
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <form:input  id="date" type="date" path = "pickUpDate" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <form:input id="time" type="time" path = "pickUpTime" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                    <form:input id="comment" path = "pickUpComment" />
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej dobrej darowizny</h3>
                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">
                    <span id="quantityView"></span>
                    worki (
                    <span id="categoriesView"></span> )</span>
                            </li>
                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text">Dla: <span id="institutionView"></span></span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li><span id="cityView"></span></li>
                                <li><span id="zipCodeView"></span></li>
                                <li><span id="streetView"></span></li>
                                <li><span id="phoneView"></span></li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li><span id="dateView"></span></li>
                                <li><span id="timeView"></span></li>
                                <li><span id="commentView"></span></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>
    </div>
</section>

<jsp:include page="footer.jsp"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="<c:url value="../../resources/js/app.js"/>"></script>
</body>
</html>

