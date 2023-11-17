create database QLBH102
go 

use QLBH102
go


drop table SANPHAM
drop table KHACHHANG
drop table HOADON
drop table NHANVIEN
drop table HOADONCHITIET
go


create table SANPHAM
(
	MaSP  nvarchar(25) not null,
	TenSP nvarchar(225) not null,
	SoLuong int not null,
	Gia  int not null,
	MauSac nvarchar(20) not null,
	ManHinh nvarchar(225) not null,
	Camera nvarchar(225) not null,
	KetNoi  nvarchar(max) not null,
	TienIch nvarchar(max) not null,
	DungLuongPin nvarchar(15) not null,
	Delete_at nvarchar(70) ,
	Delete_Uuer nvarchar(70),
	constraint PK_SANPHAM primary key(MaSP),
	constraint ck_SoLuong check(SoLuong > 0),
	constraint ck_Gia check(Gia > 0)
)
go

create table KHACHHANG
(
	MaKH nvarchar(25) not null,
	TenKH nvarchar(225) not null,
	SDT nvarchar(13) not null unique,
	DChi nvarchar(225) not null,
	Delete_at nvarchar(70) ,
	Delete_Uuer nvarchar(50),
	constraint PK_KHACHHANG primary key(MaKH)
)
go



create table NHANVIEN
(
	MaNV nvarchar(25) not null,
	TenDangNhap nvarchar(50) not null,
	MatKhau nvarchar(50) not null,
	HoTenNV nvarchar(225) not null,
	GioiTinh nvarchar(5) not null,
	ChucVu nvarchar(25) not null,
	DChi nvarchar(225) not null,
	SDT nvarchar(13) not null unique,
	Email nvarchar(225) not null unique,
	constraint Pk_NHANVIEN primary key(MaNV),
	constraint ck_ChucVu check(ChucVu like 'Boss%' or ChucVu Like 'Employee%' )
	
)
go


create table HOADON
(
	MaHoaDon nvarchar(25) not null,
	MaKH nvarchar(25) not null,
	MaNV nvarchar(25) not null,
	NgayMuaHang datetime not null,
	TongTien int not null,
	Delete_at nvarchar(70) ,
	Delete_Uuer nvarchar(50),
	constraint PK_HOADON primary key(MaHoaDon),
	constraint FK_HOADON_KHACHHANG foreign key(MaKH) references KHACHHANG(MaKH),
	constraint FK_HOADON_NHANVIEN foreign key(MaNV) references NHANVIEN(MaNV),
	
)
go

create table HOADONCHITIET
(	
	
	MaHoaDonChiTiet nvarchar(25) not null,
	MaHoaDon nvarchar(25) not null,
	MaSP nvarchar(25) not null,
	GiaBan  int not null,
	SoLuongDH int not null,
	GiamGia float not null,
	TongTien int not null,
	constraint PK_HOADONCHITIET primary key(MaHoaDonChiTiet),
	constraint FK_HOADONCHITIET_HOADON foreign key(MaHoaDon) references HOADON(MaHoaDon),
	constraint FK_HOADONCHITIET_SANPHAM foreign key(MaSP) references SANPHAM(MaSP),
	constraint ck_SoLuongDH check(SoLuongDH > 0),
	constraint ck_GiaBan check(GiaBan > 0)
)
go


---select * from SANPHAM

delete from SANPHAM where MaSP like '103'

	insert into SANPHAM(MaSP,TenSP,SoLuong,Gia,MauSac,ManHinh,Camera,KetNoi,TienIch,DungLuongPin) 
	values('101',N'iPhone 11 Pro Max 512GB',50,4199000,N'Vàng',N'OLED, 6.5", Super Retina - Full 4k',N'3 camera sau & 1 camera trước (12 MP)',N'1 eSIM & 1 Nano SIM , Wifi, Bluetooth,GPS',N'Face ID,Sạc nhanh,Apple Pay,Kháng nước,kháng bụi','3969 mAh')

	insert into SANPHAM(MaSP,TenSP,SoLuong,Gia,MauSac,ManHinh,Camera,KetNoi,TienIch,DungLuongPin) 
	values('102',N'iPhone Xs Max 256GB',60,3099000,N'Bạc',N'OLED, 6.5", Super Retina - Full 4k',N'2 camera sau (12 MP),1 camera trước (7 MP)',N'1 eSIM & 1 Nano SIM , Wifi, Bluetooth,GPS',N'Face ID,Sạc nhanh,Apple Pay,Kháng nước,kháng bụi','3174 mAh')

	insert into SANPHAM(MaSP,TenSP,SoLuong,Gia,MauSac,ManHinh,Camera,KetNoi,TienIch,DungLuongPin) 
	values('103',N'iPhone SE 256GB (2020)',50,1799000,N'Bạc',N'IPS LCD, 4.7", Retina - HD (1334 x 750 Pixels)',N'1 camera sau (12MP) & 1 camera trước (7 MP)',N'1 eSIM & 1 Nano SIM , Wifi, Bluetooth,GPS',N'Mở Khóa Vân Tay,Sạc nhanh,Kháng nước,kháng bụi','1821 mAh')

	
	insert into SANPHAM(MaSP,TenSP,SoLuong,Gia,MauSac,ManHinh,Camera,KetNoi,TienIch,DungLuongPin) 
	values('104',N'Samsung Galaxy Z Flip',50,3600000,N'Hồng',N'Super AMOLED, 6.5", FullHD+',N'2 camera sau &  1 camera trước (12 MP)',N'1 eSIM & 1 Nano SIM , Wifi, Bluetooth,GPS',N'Mở Khóa Vân Tay,Sạc nhanh,Kháng nước,kháng bụi','3300 mAh')

	
	insert into SANPHAM(MaSP,TenSP,SoLuong,Gia,MauSac,ManHinh,Camera,KetNoi,TienIch,DungLuongPin) 
	values('105',N'Samsung Galaxy S20 Ultra',50,2300000,N'Hồng',N'Super AMOLED, 6.5", FullHD+',N'2 camera sau &  1 camera trước (12 MP)',N'1 eSIM & 1 Nano SIM , Wifi, Bluetooth,GPS',N'Mở Khóa Vân Tay,Sạc nhanh,Kháng nước,kháng bụi','4500 mAh')

	-- KHACHHANG
	insert into KHACHHANG(MaKH,TenKH,SDT,DChi)
	values('KH_00001',N'Đặng Kỳ Thư','0924783902',N'93 Ngõ 512, Trương Đinh, Q.Hoàng Mai, TP.Hà Nôi')
	--
	insert into KHACHHANG(MaKH,TenKH,SDT,DChi)
	values('KH_00002',N'Đặng Tiểu Cường','0903251829',N'35 Ngõ 58, Trần Bình, Q.Cầu Giấy, TP.Hà Nôi')

	insert into KHACHHANG(MaKH,TenKH,SDT,DChi)
	values('HN_00003',N'Lý Thủy Tiên','0909127943',N'104, Ngõ Văn Chương, Q.Đống Đa,TP.Hà Nôi')

	insert into KHACHHANG(MaKH,TenKH,SDT,DChi)
	values('HN_00004',N'Trần Thị Hiền','0909126388',N'18, Ngõ Văn Chương, Q.Ba Đình,TP.Hà Nôi')
	

	---delete from KHACHHANG where MaKh like 'HN002'


	
	insert into NHANVIEN(MaNV,TenDangNhap,MatKhau,HoTenNV,GioiTinh,ChucVu,DChi,SDT,Email)
	values ('IOS001','admin','admin',N'Hoàng Quốc Bảo','Nam','Boss',N'124, Ngõ Văn Chương, Q.Đống Đa,TP.Hà Nôi','0123456789','baohq123@gmail.com'),
			('IOS002','thuytt123','1122334455',N'Lý Thu Thủy',N'Nữ','Employee',N'105 Ngõ 220, Trương Đinh, Q.Hoàng Mai, TP.Hà Nôi','0190892457','thuytt123@gmail.com'),
			('IOS003','khoadv123','3322114488',N'Đặng Văn Khoa','Nam','Employee',N'38 Ngõ 68, Trần Bình, Q.Cầu Giấy, TP.Hà Nôi','0101935928','khoadv123@gmail.com'),
			('IOS004','uername','password',N'Nguyễn Văn Đạt','Nam','Employee',N'38 Ngõ 68, Hàm Nghi, Q.Cầu Giấy, TP.Hà Nôi','0154698739','datnv123@gmail.com')

	insert into HOADON(MaHoaDon,MaNV,MaKH,NgayMuaHang,TongTien)
			values('HD_00156','IOS002','KH_00001','2020-03-04',7997000),
					('HD_00102','IOS003','HN_00003','2020-03-06',8999000),
					('HD_00135','IOS004','KH_00002','2020-04-06',4898900)
	
			

	insert into HOADONCHITIET(MaHoaDonChiTiet,MaHoaDon,MaSP,GiaBan,SoLuongDH,GiamGia,TongTien)
	values ('HD_53218','HD_00156','102',3099000,2,0,6198000),
			('HD_63245','HD_00156','103',1799000,1,0,1799000),

			('HD_39214','HD_00102','104',3600000,2,0,7200000),
			('HD_73217','HD_00102','103',1799000,2,0,1799000),

			('HD_15276','HD_00135','103',1799000,1,0,1799000),
			('HD_03687','HD_00135','102',3099000,1,0,3099000)

			

			delete from HOADONCHITIET where MaHoaDonChiTiet like 'HD_63245'
			delete from HOADON where MaHoaDon like 'HD_00101'

			select * from NHANVIEN 
			select * from SANPHAM --where Delete_at is  null
			select * from KHACHHANG 
			select *from HOADON where Delete_at is  null and MaHoaDon like'hd_00102'
			select * from HOADONCHITIET

			update HOADON set MaHoaDon = 'HD_53109' WHERE MaKH like 'KH_00001'
			
		



			
