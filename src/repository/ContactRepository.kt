package repository

import entity.ContactEntity

//repository: responsavel de salvar os dados da aplicação (Banco de dados)
class ContactRepository {
    companion object { // vai ser mantido unico durante varias instancias da classe, como se fosse uma persistencia de dados
        private val contactlist = mutableListOf<ContactEntity>()
        fun save(contact: ContactEntity) {
            contactlist.add(contact)

        }

        fun delete(contact: ContactEntity) {
            
            var index = 0
            for(i in contactlist.withIndex()){
                if(i.value.name == contact.name && i.value.phone == contact.phone)
                index= i.index
                break
            }
            contactlist.removeAt(index)
        }

        fun getList():List<ContactEntity>{
            return contactlist
        }
    }
}