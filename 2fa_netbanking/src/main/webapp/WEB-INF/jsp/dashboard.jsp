<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>RBS Digital Bank</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">
	</script> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	</script>
	
	<link href="/css/main.css" rel="stylesheet">
	<link href="/css/dashboardmain.css" rel="stylesheet">
	<link href="/css/account.css" rel="stylesheet">
	<link href="/css/payment.css" rel="stylesheet">
	
	<style>
	
	.all_functionalities_parent{
		
		display: none;
	}
	
	.div_greeting {
		display: none;
	}
	
	</style>
	
</head>
<body>
	<div>
		<nav class="navbar navbar-expand-sm nav-bar-back navbar-dark navbar-top1">
			<ul class="navbar-nav navbar-nav1">
				<li class="nav-item">
					<a class="nav-link" href="#">Personal</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Premier</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Business</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Corporate</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">International</a>
				</li>
			</ul>
		</nav>
		<nav class="navbar navbar-expand-sm nav-bar-back navbar-dark">
			<a class="navbar-brand" href="#"><img alt="logo" src="/images/r-b-s-logo-on-blue-bg.svg" style=
			"width: 118px; height: 32px"></a>
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="#">Products</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Security & Support</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">Life Moments</a>
				</li>
				<li class="nav-item-end">
					<a class="nav-link nav-last" href="#">Privacy & Cookies</a> | <a class="nav-link nav-last" href=
					"#">Accessibility</a>
				</li>
			</ul>
		</nav>
	</div><!-- Sidebar -->
	<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
		<ul class="nav sidebar-nav">
			<li>
				<a href="#" id="account_summary_link">Account Summary</a>
			</li>
			<li>
				<a href="#">Messages</a>
			</li>
			<li>
				<a href="#">Statements</a>
			</li>
			<li>
				<a href="#" id="payment_transfer_link">Payments and transfers</a>
			</li>
			<li>
				<a href="#">Alerts</a>
			</li>
			<li>
				<a href="#">Cards</a>
			</li>
			<li>
				<a href="#">Your Details</a>
			</li>
			<li>
				<a href="#">Security</a>
			</li>
			<li>
				<a href="#">Logout</a>
			</li>
		</ul>
	</nav>
	<div class="main_side">
		<div class="div_greeting">
			Hello <span id="sp_custName"></span>! Welcome !
		</div>
		<div class="div_account all_functionalities_parent" id="Account">
			<div class="ad">
				<img alt="Snow" src="/images/student.jpg" style="width: 80%; height: 200px; border-radius: 5px">
				<div class="mobileAppAD">
					Download our Award Winning Mobile App today!
				</div>
			</div>
			<div class="div_summarytop">
				<span>Account Summary</span>
			</div>
			<hr>
			<div class="div_acc_details_top">
				<span>Personal Accounts</span>
			</div><br>
			<br>
			<div class="div_accbal_tables">
				<table class="table acctable" id="t_accbal">
					<tr>
						<th>Account Name</th>
						<th>Account Number</th>
						<th>Sort Code</th>
						<th>Balance</th>
					</tr>
					<!-- <tr>
						<td>Savings</td>
						<td>10713792</td>
						<td>151000</td>
						<td>&#163;1000.00</td>
					</tr> -->
				</table>
			</div><br>
			<br>
		</div>
		<div class="div_payments all_functionalities_parent" id="Payments" style="display: none;">
			<div class="div_summarytop">
				<span>Payments and Transfers</span>
			</div>
			<hr>
			<div class="div_details_top">
				<span>Make a payment or transfer</span>
			</div>
			<div class="div_payment_details">
				What you would like to do today?<br>
				Pay bills, manage payees (the people you want to pay) or transfer money<br>
				<br>
				<span class="pay_list"><span>⮞</span>&nbsp;<a href="#" id="start_payment_link">Make a payment or transfer</a></span> <span class=
				"pay_list"><span>⮞</span>&nbsp;<a href="#">Manage Payees</a></span> <span class=
				"pay_list"><span>⮞</span>&nbsp;<a href="#">Manage Scheduled payments</a></span><br>
				<br>
			</div>
		</div>
		<div class="div_payments_enter all_functionalities_parent" id="payments1" >
			<div class="div_summarytop">
				<span>Make a payment or transfer</span>
			</div>
			<hr>
			<div class="div_payment_step">
				<span>Step 1 of 3</span>
			</div>
			<div class="div_details_top">
				<span>Enter your payment information</span> <span class="payment-sub">Transfer money between accounts,pay a bill or
				someone else</span>
			</div>
			<div class="div_payment_enter_details">
				<div class="div_payment_info">
					From<br>
					<br>
					<div>
						<select class="pay_accnum" name="fromAcc" id="fromAcc">
							<!-- <option value='10713792'>
								10713792
							</option> -->
						</select>
					</div>
				</div>
				<div class="div_payment_info">
					To<br>
					<br>
					<div>
						<select class="pay_accnum" name="toAcc" id="toAcc">
							<!-- <option value='10713793'>
								10713793
							</option> -->
						</select>
					</div>
				</div><br>
				<br>
				<div class="div_payment_info">
					Amount<br>
					<div>
						<span>&#163;</span> <input class="pay_amount" id="pay_amount" name="pay_amount" type="text" value="0.00">
					</div>
				</div>
				<div class="div_payment_button">
					<input class="payment_button" name="pay_next" type="button" value="Next">
				</div>
			</div><br>
			<br>
		</div>
		<div class="div_payments_review all_functionalities_parent" id="payments2" style="display: none;">
			<div class="div_summarytop">
				<span>Make a payment or transfer</span>
			</div>
			<hr>
			<div class="div_payment_step">
				<span>Step 2 of 3</span>
			</div>
			<div class="div_details_top">
				<span>Finally,check and authorize</span> <span class="payment-sub">Please check the sort code and account number
				you have entered carefully to ensure the funds reach to the correct person or company</span>
			</div>
			<div class="div_payment_review_details">
				<span>Confirm Payment Details</span><br>
				<br>
				<div class="div_payment_info">
					From<br>
					<div class="payment_review_info">
						Vignesh - 10713792
					</div>
				</div>
				<div class="div_payment_info">
					To<br>
					<div class="payment_review_info">
						Vicky
					</div>
				</div><br>
				<div class="div_payment_info">
					Account Number<br>
					<div class="payment_review_info">
						10713793
					</div>
				</div>
				<div class="div_payment_info">
					Sort Code<br>
					<div class="payment_review_info">
						151000
					</div>
				</div>
				<div class="div_payment_info">
					Amount<br>
					<div class="payment_review_info">
						&#163; 1000.00
					</div>
				</div>
				<div class="div_payment_button">
					<input class="payment_button" name="pay_next" type="button" value="Confirm">
				</div>
			</div><br>
			<br>
		</div>
		<div class="div_payment_2fa_start all_functionalities_parent" >
			<div class="div_summarytop">
				<span>Make a payment or transfer</span>
			</div>
			<hr>
			<div class="div_payment_step">
				<span>Step 3 of 3</span>
			</div>
			<div class="div_details_top">
				<span>2nd Step Authorization</span> <span class="payment-sub">Do a Second Step Authorization for Enhanced
				Security</span>
			</div>
			<div class="div_payment_2fa_details">
				<div id="div_2fa_start" style="display: none">
					<br>
					<div class="div_2fa_mobile"><img alt="Open Mobile" height="300px" src="/images/2FA-Check-Mobile2.gif"></div>
					<div class="div_2fa_guide">
						Hey <span id="sp_custName"></span>, Open your Mobile Banking registered mobile/tablet to authorize the payment
					</div>
				</div>
				<div id="div_2fa_timeout" style="display: none">
					You haven't authorized/rejected the payment. Want to try other options to authorize ?<br>
					<br>
					<div class="try_mobile">
						<img alt="Try Mobile" src="/images/2FA_try_mobile.jpg"> <span class="try_options">Want to try again from Mobile
						App ?</span>
					</div><br>
					<div class="try_text">
						<img alt="Try Text" src="/images/2FA_try_text.jpg"> <span class="try_options">Want to text you the verification
						code ?</span>
					</div><br>
					<div class="try_call">
						<img alt="Try Call" src="/images/2FA_try_call.jpg"> <span class="try_options">Want to call you for verification
						code ?</span>
					</div><br>
				</div>
			</div>
		</div>
		<div class="div_payment_authorized all_functionalities_parent" id="div_payment_authorized" >
			<div class="div_summarytop">
				<span>Make a payment or transfer</span>
			</div>
			<hr>
			<div class="div_details_top div_trresult_top">
				<span>Payment Transaction Completed !</span>
			</div>
			<div class="div_2fa_authorized" id="div_2fa_authorized" >
				<br>
				<div class="div_2fa_result">
					Transaction Authorized
				</div>
				<div class="div_2fa_images"><img alt="Success1" height="100px" src="/images/payment_wallet.png" width="100px">
				<img alt="Success2" height="80px" src="/images/payment_success.png" width="80px"></div>
				<div class="div_2fa_authorized_text">
					Your transaction of amount 1000.00 to Vicky is successful.
				</div>
			</div>
		</div>
		<div class="div_payment_rejected all_functionalities_parent" id="div_payment_rejected" >
			<div class="div_summarytop">
				<span>Make a payment or transfer</span>
			</div>
			<hr>
			<div class="div_details_top div_trresult_top">
				<span>Payment Transaction Failed !</span>
			</div>
			<div class="div_2fa_rejected" id="div_2fa_rejected">
				<br>
				<div class="div_2fa_result">
					Transaction Rejected
				</div>
				<div class="div_2fa_images"><img alt="Success1" height="100px" src="/images/payment_wallet.png" width="100px">
				<img alt="Success2" height="80px" src="/images/payment_rejected.png" width="80px"></div>
				<div class="div_2fa_rejected_text">
					You have rejected the Transaction of amount 1000.00 to Vicky.<br>
					Please re-initiate the transaction if you want to pay again
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" name="custNumber" id="custNumber" value="${custNumber}" />
	<input type="hidden" name="mobileID" id="custNumber" value="" />
	<input type="hidden" name="custName" id="custName" value="" />
	<input type="hidden" name="personal_accounts" id="personal_accounts" value="" />
	<script>
		
		$(document).ready(function() {
			
			$.get('/digitalBank/customer',{"custNumber":$('#custNumber').val()},function(response) {
				
				$('.div_greeting').css('display','block');
				$('#sp_custName').text(response.custName);
				$('#mobileID').val(response.mobileID);
				$('#custName').val(response.custName);
			
			showDashBoard();
			
			//Register Account Summary Handler
			$('#account_summary_link').click(showDashBoard);
			
			//Register Payment Click Handler
			$('#payment_transfer_link').click(showPaymentsTransfers);
			
			//Register Start Payment Click Handler
			$('#start_payment_link').click(showPaymentEnter);
			
			});
			
			
			
		});
		
		function getAccountDetails() {
			$.get('/digitalBank/customer/accounts',{"custNumber":$('#custNumber').val()},function(response) {
				
				$('#t_accbal').find("tr:gt(0)").remove();
				
				var acc_row;
				for(var i=0;i<response.length;i++) {
					acc_row = $('<tr/>');
					acc_row.append("<td>"+response[i].accName+"</td>");
					acc_row.append("<td>"+response[i].accountPrimaryDetails.accNo+"</td>");
					acc_row.append("<td>"+response[i].accountPrimaryDetails.sortCode+"</td>");
					acc_row.append("<td>"+"&#163;"+response[i].accBalance+"</td>");
					$('#t_accbal').append(acc_row);
				}
				
				$('#personal_accounts').val(JSON.stringify(response));
				
			});
		}
		
		function showDashBoard() {
			getAccountDetails();
			$('.all_functionalities_parent').css('display','none');
			$('#Account').css('display','block');
		}
		
		function showPaymentsTransfers() {
			$('.all_functionalities_parent').css('display','none');
			$('#Payments').css('display','block');
		}
		
		function showPaymentEnter() {
			displayOwnAndPayeeAccounts();
			$('.all_functionalities_parent').css('display','none');
			$('#payments1').css('display','block');
		}
		
		function displayOwnAndPayeeAccounts() {
			
			var personal_accounts =  JSON.parse($('#personal_accounts').val());
			for(var i=0;i<personal_accounts.length;i++) {
				$('<option/>',{value: personal_accounts[i].accountPrimaryDetails.accNo + "|" + personal_accounts[i].accountPrimaryDetails.sortCode})
				.text(personal_accounts[i].accountPrimaryDetails.accNo).appendTo('#fromAcc');
			}
			
			$.get('/digitalBank/customer/payees',{"custNumber":$('#custNumber').val()},function(payee_accounts) {
				
				for(var i=0;i<payee_accounts.length;i++) {
					$('<option/>',{value: payee_accounts[i].payeePrimaryDetails.accNo + "|" + payee_accounts[i].payeePrimaryDetails.sortCode})
					.text(payee_accounts[i].payeePrimaryDetails.accNo).appendTo('#toAcc');
					}
			});
			
		}
		
		function getPayeeAccounts() {
			
		}
	
	
	</script>
</body>
</html>