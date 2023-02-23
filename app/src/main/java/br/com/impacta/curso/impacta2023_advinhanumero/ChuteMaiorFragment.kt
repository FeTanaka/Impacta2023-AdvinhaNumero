package br.com.impacta.curso.impacta2023_advinhanumero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.impacta.curso.impacta2023_advinhanumero.databinding.FragmentChuteMaiorBinding

class ChuteMaiorFragment : Fragment() {

    private var _binding: FragmentChuteMaiorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChuteMaiorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {
            val acao = R.id.action_chuteMaiorFragment_to_inicialFragment
            findNavController().navigate(acao)
        }
    }

}