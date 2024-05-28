package org.dnyanyog.repository;

import java.util.Optional;

import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long>
{
	Optional<Users> findBypatientId(long patientId);

	Users findBymobileNumber(String mobileNumber);

	Users findByPassword(String password);


}
