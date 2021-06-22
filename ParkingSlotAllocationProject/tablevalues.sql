	INSERT INTO public.address(
	address_id, city, pin, state)
	VALUES (12, 'Bangalore', 98, 'Karnataka');
	
	INSERT INTO public.address(
	address_id, city, pin, state)
	VALUES (13, 'chennai', 98, 'TamilNadu');
	
	INSERT INTO public.address(
	address_id, city, pin, state)
	VALUES (11, 'mumbai', 98, 'Maharastra');
	
	
	INSERT INTO public.role(
	role_id, role_desc, role_name)
	VALUES (12, 'abc','abc' );
	
	INSERT INTO public.role(
	role_id, role_desc, role_name)
	VALUES (14, 'abc','abc' );
	
	INSERT INTO public.role(
	role_id, role_desc, role_name)
	VALUES (15, 'abc','abc' );
	
	INSERT INTO public.usr(
	user_id, email, first_name, is_active, last_name, mobile)
	VALUES (211, 'Wini', 'wini@gmail.com', '0', 'bedhre','123456789');
	
	INSERT INTO public.usr(
	user_id, email, first_name, is_active, last_name, mobile)
	VALUES (212, 'Sameer', 'sameer@gmail.com', '1', 'Mahammad','123456789');
	
	INSERT INTO public.usr(
	user_id, email, first_name, is_active, last_name, mobile)
	VALUES (215, 'Shabana', 'shabana@gmail.com', '0', 'Shaikh','123456789');
	
	INSERT INTO public.usr(
	user_id, email, first_name, is_active, last_name, mobile)
	VALUES (214, 'Vijay', 'vijay@gmail.com', '0', 'Janarthanan','123456789');
	
	INSERT INTO public.usr(
	user_id, email, first_name, is_active, last_name, mobile)
	VALUES (213, 'Pravin', 'pravin@gmail.com', '0', 'shankar','123456789');
	
	
	INSERT INTO public.login(
	login_id, password, role_role_id, usr_user_id)
	VALUES ('12', 'abcde',14, 211);
	
	INSERT INTO public.login(
	login_id, password, role_role_id, usr_user_id)
	VALUES ('13', 'abcde',12, 212);
	
	INSERT INTO public.login(
	login_id, password, role_role_id, usr_user_id)
	VALUES ('14', 'abcde',14, 213);
	
	INSERT INTO public.login(
	login_id, password, role_role_id, usr_user_id)
	VALUES ('16', 'abcde',14, 214);
	
	
	INSERT INTO public.login(
	login_id, password, role_role_id, usr_user_id)
	VALUES ('17', 'abcde',14, 215);
	
	
	INSERT INTO public.vehicle(
	vehicle_id, vehicle_company, vehicle_model, vehicle_number, vehicle_type, owner_user_id)
	VALUES (10,'Mahindra', 'Mahindra Thar', '12345', 0, 211);
	
	INSERT INTO public.vehicle(
	vehicle_id, vehicle_company, vehicle_model, vehicle_number, vehicle_type, owner_user_id)
	VALUES (11,'Mahindra', 'Mahindra XUV300', '12345', 2, 212);
	
	INSERT INTO public.vehicle(
	vehicle_id, vehicle_company, vehicle_model, vehicle_number, vehicle_type, owner_user_id)
	VALUES (12,'Toyota ', 'Toyota Camry', '12345', 0, 213);
	
	INSERT INTO public.vehicle(
	vehicle_id, vehicle_company, vehicle_model, vehicle_number, vehicle_type, owner_user_id)
	VALUES (13,'Mahindra', 'Mahindra Bolero', '12345', 2, 214);
	
	
	INSERT INTO public.parking_premise(
	parking_premise_id, number_of_parking_floors, parking_premise_name, premise_address_address_id)
	VALUES (10, 4, 'Shine', '11');
	
	INSERT INTO public.parking_premise(
	parking_premise_id, number_of_parking_floors, parking_premise_name, premise_address_address_id)
	VALUES (11, 4, 'Shine', '12');
	

	INSERT INTO public.parking_premise(
	parking_premise_id, number_of_parking_floors, parking_premise_name, premise_address_address_id)
	VALUES (12, 1, 'Building', '13');
	
	
	INSERT INTO public.parking_floor(
	parking_floor_id, floor_number, number_of_parking_slots, parking_premise_parking_premise_id)
	VALUES (10, '2', 10, 10);
	
	INSERT INTO public.parking_floor(
	parking_floor_id, floor_number, number_of_parking_slots, parking_premise_parking_premise_id)
	VALUES (11, '1', 11, 11);
	
	INSERT INTO public.parking_floor(
	parking_floor_id, floor_number, number_of_parking_slots, parking_premise_parking_premise_id)
	VALUES (12, '3', 12, 12);
	
	
	INSERT INTO public.payment(
	payment_id, amount_paid, payment_date_time, status, type)
	VALUES (100, 200, '2019-05-13', 0, 0);
	
	INSERT INTO public.payment(
	payment_id, amount_paid, payment_date_time, status, type)
	VALUES (101, 200, '2019-05-18', 1, 1);
	
	INSERT INTO public.payment(
	payment_id, amount_paid, payment_date_time, status, type)
	VALUES (102, 800, '2019-05-12', 0, 2);
	
	INSERT INTO public.payment(
	payment_id, amount_paid, payment_date_time, status, type)
	VALUES (103, 500, '2020-06-12', 1, 2);
	
	
	INSERT INTO public.parking_slots(
	parking_slot_id, booking_date, parking_date, parking_duration, parking_time, parking_floor_parking_floor_id, payment_payment_id, vehicle_vehicle_id)
	VALUES (10, '2019-05-12', '2019-05-13', '2', '1:00AM',10, 100, 10);
	
	INSERT INTO public.parking_slots(
	parking_slot_id, booking_date, parking_date, parking_duration, parking_time, parking_floor_parking_floor_id, payment_payment_id, vehicle_vehicle_id)
	VALUES (11, '2019-05-12', '2019-05-13', '2', '2:00AM',11, 101, 12);
	
	INSERT INTO public.parking_slots(
	parking_slot_id, booking_date, parking_date, parking_duration, parking_time, parking_floor_parking_floor_id, payment_payment_id, vehicle_vehicle_id)
	VALUES (12, '2020-05-12', '2020-05-13', '2', '2:00AM',11, 101, 12);
	
	INSERT INTO public.parking_slots(
	parking_slot_id, booking_date, parking_date, parking_duration, parking_time, parking_floor_parking_floor_id, payment_payment_id, vehicle_vehicle_id)
	VALUES (13, '2020-07-12', '2020-07-13', '9', '9:00AM',11, 103, 13);
	
	
	
	
	
	
	
	
	