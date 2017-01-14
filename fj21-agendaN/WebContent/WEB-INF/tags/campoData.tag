<%@ attribute name="id" required="true" %>

<input id="${id}" name="${id}" />
<script>
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
// 	$("#${id}").datepicker({changeYear: true});
// 	$("#${id}").datepicker({changeMonth: true});
</script>