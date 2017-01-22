<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="false"%>

<input type="text" id="${id }" name="${id }" value="${value }" />

<%-- <input id="${id}" name="${id}" /> --%>
<script>
	$("#${id}").datepicker({
		dateFormat: 'dd/mm/yy'
		}).datepicker({
			changeYear: true
		}).datepicker({
			yearRange: '1940:2045'
		}).datepicker({
			changeMonth: true
		});
// 	$("#${id}").datepicker({changeYear: true});
// 	$("#${id}").datepicker({changeMonth: true});
</script>