Feature: Purchase a "PAPER TICKET EVENT 2" event ticket
Scenario: User can purchase an event ticket for a registered account.Maximum purchase limit for an account is five.
If user tries to purchase more than five tickets then user gets an error message.

Given user is on PAPER TICKET EVENT 2
When user clicks on BOOK NOW CTA
Then No of tickets and CHECKOUT CTA get displayed in Select tickets section
And user enters no of tickets and clicks on CHECKOUT CTA
Then it navigates to Account section

Given user is on login tab of account section
When user enters valid phone number 7823879944
And user clicks on VERIFY PHONE NUMBER CTA
Then it navigates to verification section

Given user is on Verification section
When user enters four digits code in VERIFY PHONE NUMBER input box
Then it either navigates to Payment section or dislays an error based on maximum purchase limit

Given user is on Payment section
When user enters valid Card number, Expiry date and CVV
And user clicks on PURCHASE TICKETS CTA
Then user can see purchased event details

