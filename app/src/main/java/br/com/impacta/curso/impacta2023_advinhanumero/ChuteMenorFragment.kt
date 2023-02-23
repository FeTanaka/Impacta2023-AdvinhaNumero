package br.com.impacta.curso.impacta2023_advinhanumero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.impacta.curso.impacta2023_advinhanumero.databinding.FragmentChuteMenorBinding


class ChuteMenorFragment : Fragment() {

    private var _binding: FragmentChuteMenorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChuteMenorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button3.setOnClickListener {
            val acao = R.id.action_chuteMenorFragment_to_inicialFragment
            findNavController().navigate(acao)
        }
    }


}