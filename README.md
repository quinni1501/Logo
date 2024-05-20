# **CHI TIẾT HƯỚNG DẪN XÂY DỰNG VÀ PHÁT TRIỂN TỪNG CHỨC NĂNG CỦA ỨNG DỤNG ĐẶT VÉ XEM PHIM**
----
## 1. Usecase Diagram
![new](https://github.com/quinni1501/Logo/assets/167750800/9c5482fe-3473-4876-9e7b-3b8edbd7927d)

## 2. Sequence Diagram
![image](https://github.com/quinni1501/Logo/assets/167750800/6da19a94-0bfb-47e4-b3c2-5d8aadd84e94)

## 3. API
- Users:
```
[
    {
        "userId": 1,
        "username": "anhthu",
        "password": "123",
        "userAvatar": "",
        "userFullname": "Anh Thư",
        "userGender": "N?",
        "userEmail": "anhthu@gmail.com",
        "userPhone": "0123456789"
    },
    {
        "userId": 2,
        "username": "phuongnguyen",
        "password": "456",
        "userAvatar": "",
        "userFullname": "Đông Phương",
        "userGender": "N?",
        "userEmail": "phuongnguyen@gmail.com",
        "userPhone": "9876543210"
    },
    {
        "userId": 3,
        "username": "huongquyen",
        "password": "789",
        "userAvatar": "",
        "userFullname": "Hương Quyên",
        "userGender": "N?",
        "userEmail": "huongquyen@gmail.com",
        "userPhone": "0147258369"
    },
    {
        "userId": 5,
        "username": "truongthu",
        "password": "147",
        "userAvatar": "",
        "userFullname": "Trương Thư",
        "userGender": "N?",
        "userEmail": "truongthu@gmail.com",
        "userPhone": "0963825741"
    },
    {
        "userId": 9,
        "username": "tnat8628",
        "password": "123",
        "userAvatar": "N?",
        "userFullname": "Trương Nguyễn Anh Thư",
        "userGender": "N?",
        "userEmail": "truongthu8628@gmail.com",
        "userPhone": "0853002471"
    }
]

```

- Category:
```
[
    {
        "categoryId": 1,
        "name": "Mystery"
    },
    {
        "categoryId": 2,
        "name": "Thriller"
    },
    {
        "categoryId": 3,
        "name": "Fantasy"
    },
    {
        "categoryId": 4,
        "name": "Adventure"
    },
    {
        "categoryId": 5,
        "name": "Comedy"
    },
    {
        "categoryId": 6,
        "name": "Romance"
    },
    {
        "categoryId": 7,
        "name": "Horror"
    },
    {
        "categoryId": 8,
        "name": "Animation"
    }
]
```
  - Links API:
    [Users](http://192.168.97.222:8188/api/users?fbclid=IwZXh0bgNhZW0CMTAAAR2wZEkzZVgfcu5tGCVXlyEqpgtZ9azloPNwIkp4YjesWG8mbjPBQ6GLBeM_aem_AfvoM2Qus7PvU5KLEJyrRn8Ilg9G0ee7U5XrzkU6fKzQl_hg9cPdPEsnYGw-lKXYgUbfGWmOn6nMlUkIul83DLlR)
    [Category](http://192.168.97.222:8188/api/moviecategory?fbclid=IwZXh0bgNhZW0CMTAAAR0InFX6KQRUCKOgqqdGlAB5ehGXXjQ_jJjiLDuQRb9y8OmuvprNgm-l7eQ_aem_AfuT0Nw1auSYN8dQdQBKAaTQseksTSpPFdeOkFfC_sxQBq5nXAimkqOwdv7e1OUZHQMxW-EeAaHJcZmNPMUO3KW7)

## 4. Giao Diện App
   - SplashActivity: ![image](https://github.com/quinni1501/Logo/assets/169877289/a8441145-c908-4107-9b3e-a1da133984a5)
   - MainActivity:
     ![image](https://github.com/quinni1501/Logo/assets/169877289/8dd2f336-72f1-4feb-9244-0881310ec6ea)
   - FilmActivity:
     ![image](https://github.com/quinni1501/Logo/assets/169877289/3a72173a-fe26-493c-b168-6ee6676ae60e)
  - DetailFilmActivity:
    ![image](https://github.com/quinni1501/Logo/assets/169877289/3b60dac3-f290-4abd-8cd3-d29bb408b6f6)
  - ShowtimesActivity:
    ![image](https://github.com/quinni1501/Logo/assets/169877289/e375d833-d280-456d-b03c-570f402d9420)
  - SeatsActivity:
    ![image](https://github.com/quinni1501/Logo/assets/169877289/a4b2634a-4033-4532-a9e6-bd1aacb0b24b)
    ![image](https://github.com/quinni1501/Logo/assets/169877289/7271eb17-f1c3-48df-accd-9f487fb97f07)
  -  VoucherActivity:
    ![image](https://github.com/quinni1501/Logo/assets/169877289/aaea8e82-d804-43c8-947f-a9a8cdaaa187)
 - ProfileActivity:
   ![image](https://github.com/quinni1501/Logo/assets/169877289/bd26de97-fe3f-4201-a58a-c12749e132d9)
 - LoginActivity:
   ![image](https://github.com/quinni1501/Logo/assets/169877289/9c466b0e-cd75-428e-8d15-8f6397eaa1bd)
 - SignUpActivity:
   ![image](https://github.com/quinni1501/Logo/assets/169877289/d635f0b1-cc29-407a-9717-82fb4153076f)

 



 




