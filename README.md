# Case2

## Not:
application.properties içerisinde ```server.servlet.context-path=/case2``` şeklinde verilmiştir. Bu sebeple proje local host ile çalıştırıldıktan sonra Swagger UI ve H2 Database'e ulaşmak için URI'ye '/case2' eklenmelidir.

Swagger UI: http://localhost:8080/case2/swagger-ui/index.html

H2 Database: http://localhost:8080/case2/h2-console/login.jsp





## Adres Kayıt Sistemi:  
Bir adreste bulunması gereken alanlar:  
- Ülke 
-  Şehir 
-  İlçe 
-  Mahalle 
-  Sokak 
-  Kapı No  
-  Daire No 
Bir adet controller yazınız(Tek controller yeterli). Bu controller içerisinde aşağıdaki işlemler yapılabilmelidir.  
1. Ülke kaydedilebilmelidir. 
2. Ülke kodundan ülke sorgulanabilmelidir. 
3. Şehir kaydedilebilmelidir. 
4. Plakadan şehir bilgisi sorgulanabilmelidir.
5. İlçe  kaydedilebilmelidir. 
6. Bir ile ait ilçeler sorgulanabilmelidir.
7. Mahalle kaydedilebilmelidir. 
8. Mahalle adını güncellenebilmelidir.  
9. Bir ilçeye ait mahalleler sorgulanabilmelidir. 
10. Sokak kaydedilebilmelidir. 
11. Sokak adı güncellenebilmelidir. 
12. Bir mahalleye ait sokaklar sorgulanabilmelidir.
13. Adres kaydedilebilmelidir.  
14. Adres silinebilmelidir. 
15. Id den adres bilgisi edinilebilmelidir. 
 
### NOT:  
- Address entitysi hariç diğer entitylerin servislerinde entity kullanabilirsiniz. Yani metot parametresi için dto, return için başka bir dto kullanmanıza gerek yok.  
- Address kaydeden dönen vs yerlerde mapper ya da converterlar kullanarak DTO ile veri akışını sağlayınız.
