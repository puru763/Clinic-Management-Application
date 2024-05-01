package com.ClinicManagementSystem.DoctorManagementMicroservice.service;


@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DoctorDto DoctorSignIn(DoctorDto doctorSignInRequest) {
        DoctorEntity doctorEntity = doctorRepository.findByMobileAndPassword(doctorSignInRequest.getMobile(), doctorSignInRequest.getPassword());
        if (doctorEntity != null) {
            DoctorDto doctorDto = new DoctorDto();
            doctorDto.setId(doctorEntity.getId());
            doctorDto.setFname(doctorEntity.getFname());
            doctorDto.setLname(doctorEntity.getLname());
            doctorDto.setMobile(doctorEntity.getMobile());
            return doctorDto;
        } else {
            return null;
        }
    }

    @Override
    public DoctorDto DoctorSignUp(DoctorDto doctorSignUpRequest) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorSignUpRequest.getId());
        doctorEntity.setFname(doctorSignUpRequest.getFname());
        doctorEntity.setLname(doctorSignUpRequest.getLname());
        doctorEntity.setMobile(doctorSignUpRequest.getMobile());
        doctorEntity.setPassword(doctorSignUpRequest.getPassword());
        doctorRepository.save(doctorEntity);
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctorEntity.getId());
        doctorDto.setFname(doctorEntity.getFname());
        doctorDto.setLname(doctorEntity.getLname());
        doctorDto.setMobile(doctorEntity.getMobile());
        return doctorDto;
    }
}

