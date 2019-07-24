# Event-Purchase-Flow

Pre-requisites: Java, Eclipse for Java with Maven plug in

Steps to execute:
Install Natural plugin from Eclipse Market place
Import project
Run testRunner.java using Junit

Event purchase flow
1. Navigate to a purchase enabled event webpage with an event id. 
2. Proceed to purchase an event ticket, via 'Select Tickets', 'Account', 'Verification' and 'Payment' options listed in progress bar.
3. Once payment is successful, user can see the success mesage.
4. If the user tries to book more than five tickets for same registered account then application displays an error message.

Note:Please update any valid registered phone number (e.g: Test data1, Testdata2) for in Scenario 2/line no 12 of the feature file.
Test data1: 7823879944 has reached the maximum number of purchase limit.
Test data2: 7800007275 hasn't reached the maximum purchase limit yet.
