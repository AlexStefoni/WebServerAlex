# WebServerAlex
svv-project
SVV-project

Scuzati de proiectul inatarziat, ma descurc foarte greu la partea de webserver intrucat nu am mai facut asa ceva si dupa nu stiu cate tutoriale am reusit sa intleg ceva am facut doar o pagina statica intrucat nu am reusit sa inteleg indeplin cum functioneaza requesturile si linkurile , dar tutorialu pe care l am urmat ma ajutat sa implementez intr o masura un request parser si sa il testez.

am folosit maven cu dependente pentru jsoup,mochito,junit5,jackson
using open-jdk 17 with intelij
mockito-core 3.12.4
the RELEASE version of junit jupiter




o sa revin aici pt ca am cam grabit toata treaba scuzati

[143661561-d4bf6634-a7ae-4e36-b743-d3b274accaef](https://user-images.githubusercontent.com/62361292/144742662-55c48164-ffc1-458a-a15d-71075b016f5d.png)


i have a failure when i try to test the websocket but i dont get why 
[image](https://user-images.githubusercontent.com/62361292/144742710-9e5f7622-5e2d-4e55-9c9e-e3527b00ec56.png)



back at it amincercat sa mai fac ceva teste dar nu a isit ceva intrucat calsele principale sunt ServerLisener Si worker care au in componeta doar un construcotr si un overwrite la metoda void run() la care  nu gasesc nici o sursa despre cum as pute o testa am vazut undeva un thread despre cum as putea face treaba altfel dar nu a mers 
o sa adaug pentru proiectul final niste parsere si clase de utils care vor fii mult mai testabile .
update 
![image](https://user-images.githubusercontent.com/62361292/145144638-a3cbe16c-f0d8-4560-8506-6224753024c7.png)








#Static Analysis


![143662653-2c9f3d6b-8896-4151-bc2f-7e1329b0628d](https://user-images.githubusercontent.com/62361292/144742615-66dedc9f-9bdc-4489-93e1-fb04a4cbcfd2.png)


i also got an IDE fatal error and i have no idea what it means image
![143662692-e9414dc4-dfaa-49db-a7f4-344775f3ea8c](https://user-images.githubusercontent.com/62361292/144742631-635ad3c0-3360-4613-af58-fe51ade81f5a.png)


#dynamic analisis 

![143663396-75efa568-7857-43c3-8b7a-f993a8420a18](https://user-images.githubusercontent.com/62361292/144742575-72230d48-b50e-48ac-86cc-c39e03705cc8.png)
![143663413-d174af6e-1fe6-43e4-816e-a6dd73204c58](https://user-images.githubusercontent.com/62361292/144742579-eae51382-243c-4e10-9ff2-e8264b3b9ff4.png)
![143663450-1df6dd57-60fa-4a2e-9821-5508d43dcf0d](https://user-images.githubusercontent.com/62361292/144742581-90761639-bab3-4025-ac10-8283f7f8d84e.png)
![143663472-cd248966-1682-43b0-960f-1945f4d62c3b](https://user-images.githubusercontent.com/62361292/144742586-ededd980-b708-4af1-9ab5-b49e31f17574.png)
![143663493-a3dbee26-b1c7-45e1-90a8-8e3be6bb89df](https://user-images.githubusercontent.com/62361292/144742595-c2712a46-6103-4525-bf90-e11243bc801a.png)
