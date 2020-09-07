<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="mytags" uri="/WEB-INF/tags.tld"%>

<mytags:static/>

<br>
<hr>

<mytags:attr condition="true" /><br>
<mytags:attr condition="false" /><br>
<mytags:attr condition="${2 > 1 }" /><br>
<mytags:attr condition="<%=2 < 1 %>" /><br>

<hr>

<mytags:h>Some text in h6</mytags:h>
<mytags:h type="h5">Some text in h5</mytags:h>
<mytags:h type="h4">Some text in h4</mytags:h>
<mytags:h type="h3">Some text in h3</mytags:h>
<mytags:h type="h2">Some text in h2</mytags:h>
<mytags:h type="h1">Some text in h1</mytags:h>
<mytags:h type="h0">Some text in h6</mytags:h>

<hr>

<mytags:loop count="-2">NULL</mytags:loop><br>
<mytags:loop count="5">5 </mytags:loop><br>
<mytags:loop count="${ 1 + 4 }">${ 1 + 4 } </mytags:loop><br>
<mytags:loop count="<%=1+4 %>">
    <mytags:attr condition="${2 > 1 }" />
</mytags:loop><br>

<hr>

<mytags:uppercase>This is test!</mytags:uppercase>