# School Management System — ERD (Phase 0)

Status: draft
 
---

## CURRENT ERD

                          ┌──────────────┐
                          │    USERS     │
                          └──────┬───────┘
                                 │
                                 │
                         ┌───────▼────────┐
                         │   USER_ROLES   │
                         └───────┬────────┘
                                 │
                         ┌───────▼────────┐
                         │     ROLES      │
                         └────────────────┘


      ┌──────────────┐
      │   STUDENTS   │
      └───────┬──────┘
              │
              │
              │
       ┌──────▼───────┐
       │  ENROLLMENTS │
       └──────┬───────┘
              │
        ┌─────┴───────────────┐
        │                     │
        ▼                     ▼
┌───────────────┐      ┌──────────────┐
│    CLASSES    │      │ ACADEMIC     │
│               │─────▶│    YEARS     │
└───────┬───────┘      └──────┬───────┘
        │                     │
        │                     │
        │                ┌────▼───────┐
        │                │   TERMS    │
        │                └────────────┘
        │
        │
        ▼
┌────────────────┐
│ CLASS_SUBJECTS │
└───────┬────────┘
        │
        ▼
┌────────────────┐
│    SUBJECTS    │
└───────┬────────┘
        │
        │
        ▼
┌──────────────────────┐
│ TEACHING_ASSIGNMENTS │
└──────────┬───────────┘
           │
           ▼
      ┌──────────┐
      │ TEACHERS │
      └──────────┘


       ┌──────────┐
       │ TEACHERS │
       └────┬─────┘
            │
            ▼
     ┌───────────────┐
     │CLASS_TEACHERS │
     └───────┬───────┘
             │
             ▼
          CLASSES


CLASS_SUBJECT
        │
        ▼
┌──────────────┐
│ ASSESSMENTS  │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│    SCORES    │◀──────── STUDENTS
└──────────────┘


┌──────────────┐
│  GUARDIANS   │
└───────┬──────┘
        │
        ▼
┌────────────────────┐
│ STUDENT_GUARDIANS  │
└─────────┬──────────┘
          │
          ▼
      STUDENTS

## CONCEPTUAL CHAIN

ACADEMIC YEAR
│
▼
CLASS
│
▼
CLASS SUBJECT
│
▼
ASSESSMENT
│
▼
SCORE
▲
│
STUDENT
▲
│
ENROLLMENT
│
▼
CLASS

---

## V1 DATABASE SCOPE

IDENTITY
├── users
├── roles
└── user_roles

PEOPLE
├── students
├── teachers
├── guardians
└── student_guardians

ACADEMIC STRUCTURE
├── academic_years
├── terms
├── classes
└── subjects

ENROLLMENT & TEACHING
├── enrollments
├── class_subjects
├── teaching_assignments
└── class_teachers

ASSESSMENT
├── assessments
└── scores

### Dependency direction

                         users
                           │
                      user_roles
                           │
                         roles


├──students
│
▼
enrollments
│
▼
classes
│
▼
class_subjects
│
▼
subjects
│
▼
assessments
│
▼
scores


teachers
│
├──────────────► teaching_assignments
│                       │
│                       ▼
│                 class_subjects
│
└──────────────► class_teachers
                        │
                        ▼
                    classes


students
│
▼
student_guardians
▲
│
guardians

### PostgreSQL conventions

#### IDs
 => BIGINT GENERATED ALWAYS AS IDENTITY
#### Timestamps
 => TIMESTAMPTZ

## Clarity
1. User = authentication/account
   not User = Student/Teacher/Guardian
2. roles examples: ADMIN
   PRINCIPAL
   DEAN
   TEACHER
   STUDENT
   GUARDIAN
   ANALYST
3. Guardian ≠ User
   A guardian can exist in school records without having portal access.
4. Since classes are already year-specific, we don't need: academic_year_id
5. 