// todo

JWT（JSON Web Token）是一个开放标准（RFC 7519），它定义了一种紧凑的、自包含的方式，用于作为JSON对象在各方之间安全地传输信息。这些信息可以被验证和信任，因为它们是数字签名的。JWTs 可以使用密钥（使用HMAC算法）或使用RSA或ECDSA的公钥/私钥对进行签名。

JWT的结构通常如下：

Header（头部）：包含两部分信息，令牌的类型（即JWT）和所使用的签名算法（例如HMAC SHA256或RSA）。

```json
{  
    "alg": "HS256",  
    "typ": "JWT"  
}
```
这部分被Base64Url编码。
2. Payload（负载）：包含声明（claims）。声明是关于实体（通常是用户）和其他数据的声明。声明有三种类型：registered, public, and private。

```json
{  
    "sub": "1234567890",  
    "name": "John Doe",  
    "admin": true  
}
```
这部分也被Base64Url编码。
3. Signature（签名）：签名部分是对上述两部分进行签名，以防止数据被篡改。

```plaintext
HMACSHA256(  
    base64UrlEncode(header) + "." +  
    base64UrlEncode(payload),  
    secret  
)
```
最终，一个完整的JWT看起来是这样的：xxxxx.yyyyy.zzzzz，其中每部分都是Base64Url编码的。

JWT通常用于以下场景：

授权：这是JWT最常见的使用场景。一旦用户登录，每个后续请求都将包含JWT，允许用户访问该令牌允许的路由、服务和资源。单点登录（SSO）是JWT的典型应用。
信息交换：JWT是在各方之间安全地传输信息的好方法。因为JWT可以被签名（例如，使用公钥/私钥对），所以你可以确定发件人是谁以及消息是否被篡改。
尽管JWT有很多优点，但它也有一些缺点和考虑因素，例如：

JWT的大小比传统的会话ID要大，因此可能会增加网络传输的开销。
JWT一旦签发，除非过期，否则无法撤销。这意味着如果你需要立即撤销用户的访问权限，使用JWT可能会有些困难。
JWT的安全性依赖于其签名密钥的安全。如果密钥被泄露，那么攻击者可以伪造JWT。
因此，在选择使用JWT时，需要仔细考虑其适用性和潜在的安全风险。
