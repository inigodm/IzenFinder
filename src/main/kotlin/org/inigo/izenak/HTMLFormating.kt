package org.inigo.izenak

fun formatHTML(izenak: List<IzenData>): String {
    return beginHTML +
    izenak.map { buildIlElement(it.izena, it.esanahia) } +
    endHTML
}

fun buildIlElement(izena: String, esanNahia: String): String{
    return "<li class=\"list-group-item\"  data-toggle=\"tooltip\" data-html=\"true\" data-placement=\"bottom\"  title=\"<i>${esanNahia.replace('"', '\'')}</i>\">"+
            "<button type=\"button\" class=\"btn btn-outline-black btn-lg btn-block\" style=\"text-align:left\" onclick=\"\$(this).closest('li').tooltip('hide');$(this).closest('li').remove();\">$izena</button>"+
            "</li>";
}

var beginHTML = "<!doctype html>"+
        "<html lang=\"eu\">"+
        "<head>"+
        "<title>Izenak</title>"+
        "<meta charset=\"utf-8\">"+
        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"+
        "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">"+
        "</head>"+
        "<body>"+
        "<div class=\"jumbotron\">"+
        "<ul id=\"main-ul\" class=\"list-group\">"

var endHTML = "</ul>"+
        "</div>"+
        "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>"+
        "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>"+
        "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>"+
        "<script>"+
        "$(function () {"+
        "    $('[data-toggle=\"popover\"]').tooltip();"+
        "    $('[data-toggle=\"tooltip\"]').tooltip();"+
        "})"+
        "</script>"+
        "</body>"+
        "</html>"