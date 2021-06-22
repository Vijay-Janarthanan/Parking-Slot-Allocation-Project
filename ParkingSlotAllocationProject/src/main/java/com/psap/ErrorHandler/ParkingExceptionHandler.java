package com.psap.ErrorHandler;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.psap.exceptions.DuplicateParkingFloorException;
import com.psap.exceptions.DuplicateParkingPremiseException;
import com.psap.exceptions.DuplicateUserException;
import com.psap.exceptions.DuplicateVehicleException;
import com.psap.exceptions.InvalidLoginCredintialException;
import com.psap.exceptions.NoSuchParkingFloorException;
import com.psap.exceptions.NoSuchParkingPremiseException;
import com.psap.exceptions.NoSuchParkingSlotException;
import com.psap.exceptions.NoSuchPaymentFoundException;
import com.psap.exceptions.NoSuchUserException;
import com.psap.exceptions.NoSuchVehicleException;
import com.psap.exceptions.NotificationException;
import com.psap.exceptions.ParkingSlotNotAvailableException;
import com.psap.exceptions.PaymentFailureException;


@ControllerAdvice
public class ParkingExceptionHandler {
	
	
	@ExceptionHandler(DuplicateParkingFloorException.class)
	public ResponseEntity<?> handleEmployeeDataError(DuplicateParkingFloorException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","parking Floor already exists");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(DuplicateParkingPremiseException.class)
	public ResponseEntity<?> handleEmployeeDataError(DuplicateParkingPremiseException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","parking Premise already exists");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(DuplicateUserException.class)
	public ResponseEntity<?> handleEmployeeDataError(DuplicateUserException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","User already exists");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(DuplicateVehicleException.class)
	public ResponseEntity<?> handleEmployeeDataError(DuplicateVehicleException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","Vehicle already exists");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(InvalidLoginCredintialException.class)
	public ResponseEntity<?> handleEmployeeDataError(InvalidLoginCredintialException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","Login credintials are invalid");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(NoSuchParkingFloorException.class)
	public ResponseEntity<?> handleEmployeeDataError(NoSuchParkingFloorException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","Parking floor does not exist");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(NoSuchParkingPremiseException.class)
	public ResponseEntity<?> handleEmployeeDataError(NoSuchParkingPremiseException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","Parking premise does not exist");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(NoSuchParkingSlotException.class)
	public ResponseEntity<?> handleEmployeeDataError(NoSuchParkingSlotException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","Parking Slot does not exist");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(NoSuchPaymentFoundException.class)
	public ResponseEntity<?> handleEmployeeDataError(NoSuchPaymentFoundException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","Payment not found");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(NoSuchUserException.class)
	public ResponseEntity<?> handleEmployeeDataError(NoSuchUserException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","User Unavailable");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(NoSuchVehicleException.class)
	public ResponseEntity<?> handleEmployeeDataError(NoSuchVehicleException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","Vehicle Unavailable");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(NotificationException.class)
	public ResponseEntity<?> handleEmployeeDataError(NotificationException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","Notification Exception");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(ParkingSlotNotAvailableException.class)
	public ResponseEntity<?> handleEmployeeDataError(ParkingSlotNotAvailableException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","Parking slot unavaiable");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
	@ExceptionHandler(PaymentFailureException.class)
	public ResponseEntity<?> handleEmployeeDataError(PaymentFailureException e){
		
		Map<String,Object> error = new LinkedHashMap<>();
		
		error.put("error : ","Payment failed");
		error.put("message : ", e.getMessage());
		error.put("timeStamp : ", LocalDate.now().toString());
		return new ResponseEntity<Object>(error,HttpStatus.BAD_REQUEST);		
		
	}
	
}
